#!/usr/bin/env bash
# Dumps class list + public signatures of the Minecraft jar Loom downloaded, so the 26.3 class list can be written from real names.
set -u
OUT="${1:-mc-api}"
mkdir -p "$OUT"
JAR=""
while IFS= read -r j; do
  if unzip -l "$j" 2>/dev/null | grep -q 'net/minecraft/client/Minecraft.class'; then JAR="$j"; break; fi
done < <(find ~/.gradle "$GITHUB_WORKSPACE" -name '*.jar' -size +10M 2>/dev/null | grep -v -E 'sources|javadoc' )
echo "Minecraft jar: $JAR" | tee "$OUT/jar-path.txt"
[ -z "$JAR" ] && exit 1
unzip -Z1 "$JAR" | grep -E "^(net/minecraft|com/mojang/blaze3d|com/mojang/math|com/mojang/blaze3d)/.*\.class$" | sed 's/\.class$//; s#/#.#g' | sort > "$OUT/classes.txt"
wc -l "$OUT/classes.txt"
# public/protected signatures, 400 classes per javap call
grep -v '\$[0-9]' "$OUT/classes.txt" | xargs -n 400 javap -protected -cp "$JAR" > "$OUT/signatures.txt" 2>"$OUT/javap-errors.txt"
wc -l "$OUT/signatures.txt"


# Fabric API (public api packages only)
FAPI="$OUT/fabric-api"; mkdir -p "$FAPI"
find ~/.gradle/caches/modules-2/files-2.1/net.fabricmc.fabric-api -name '*.jar' ! -name '*sources*' ! -name '*javadoc*' 2>/dev/null | sort > "$FAPI/jars.txt"
wc -l "$FAPI/jars.txt"
: > "$FAPI/classes.txt"
while read -r j; do unzip -Z1 "$j" 2>/dev/null | grep -E '^net/fabricmc/fabric/api/.*\.class$' | grep -v '\$[0-9]' | sed 's/\.class$//; s#/#.#g' >> "$FAPI/classes.txt"; done < "$FAPI/jars.txt"
sort -u -o "$FAPI/classes.txt" "$FAPI/classes.txt"
wc -l "$FAPI/classes.txt"
CP="$(paste -sd: "$FAPI/jars.txt"):$JAR:$(find ~/.gradle/caches/modules-2/files-2.1 \( -path '*com.mojang*' -o -path '*org.joml*' -o -path '*it.unimi*' -o -path '*com.google.guava*' -o -path '*org.slf4j*' -o -path '*net.fabricmc/fabric-loader*' \) -name '*.jar' ! -name '*sources*' 2>/dev/null | paste -sd:)"
grep -v 'package-info' "$FAPI/classes.txt" | xargs -n 300 javap -protected -cp "$CP" > "$FAPI/signatures.txt" 2>"$FAPI/javap-errors.txt"
wc -l "$FAPI/signatures.txt"
