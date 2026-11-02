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

# Where do the vertex/GPU classes live? (they are not all in the Minecraft jar in 26.x)
{
  for c in com/mojang/blaze3d/vertex/VertexFormat com/mojang/blaze3d/vertex/Tesselator com/mojang/blaze3d/vertex/VertexFormatElement; do
    echo "## $c"
    find ~/.gradle "$GITHUB_WORKSPACE" -name '*.jar' 2>/dev/null | while read -r j; do unzip -l "$j" 2>/dev/null | grep -q "$c.class" && echo "$j"; done
  done
  echo "## any class named *VertexFormat*|*Tesselator* in any jar"
  find ~/.gradle -name '*.jar' 2>/dev/null | while read -r j; do unzip -Z1 "$j" 2>/dev/null | grep -E 'VertexFormat|Tesselator|NativeImage' | sed "s#^#$j :: #"; done | head -60
} > "$OUT/where-is.txt" 2>&1
