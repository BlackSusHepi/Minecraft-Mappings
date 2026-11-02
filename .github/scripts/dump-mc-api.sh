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
unzip -Z1 "$JAR" | grep '^net/minecraft/.*\.class$' | sed 's/\.class$//; s#/#.#g' | sort > "$OUT/classes.txt"
wc -l "$OUT/classes.txt"
# public/protected signatures, 400 classes per javap call
grep -v '\$[0-9]' "$OUT/classes.txt" | xargs -n 400 javap -protected -cp "$JAR" > "$OUT/signatures.txt" 2>"$OUT/javap-errors.txt"
wc -l "$OUT/signatures.txt"
