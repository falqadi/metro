# item5: Dagger reproducer for "Map<K, Provider<V>> is rebuilt with new factories on every read"

Metro side: the dump test `compiler-tests/src/test/data/dump/ir/upstream/Item5ProviderMapMetro.kt.txt` (two String-keyed entries, "alpha" and "beta"), the dump tests `Item5ProviderMapIncludedDeps20Metro.kt.txt` and `Item5ProviderMapIncludedDeps20DaggerInterop.kt.txt` (20 entries, each takes 3 dependencies from an `@Includes` interface), and the box tests `compiler-tests/src/test/data/box/upstream/Item5ProviderMapIncludedDeps{,100}{Metro,DaggerInterop}.kt`, which print the bytes allocated per map read. All are on this branch.

The Dagger fixture, `src/main/java/repro/Fixtures.java`, has the same shapes: `TwoEntryGraph` (alpha and beta, one `Dep` each), and `Graph20` and `Graph100`, where every entry takes 3 dependencies from an included `Deps` interface. `Main` prints the bytes allocated per map read, after warm-up (`ThreadMXBean`, 20,000 warm-up reads, then 3 rounds of 10,000 reads).

## Run

```
./gradlew run
```

Needs JDK 17 or newer and access to Maven Central. The project uses Dagger 2.60.1 (the version Metro main pins) as an annotation processor, with `-Adagger.fastInit=enabled`, Dagger's counterpart of Metro's switching providers.

The Dagger source that the processor generated is committed in `generated/`. It is the unedited output of Dagger 2.60.1 for `src/main/java/repro/Fixtures.java`, copied from `build/generated/sources/annotationProcessor/java/main/repro/`. Every code block in this file is an exact excerpt of a committed file, and the line numbers are given above each block.

In `generated/` only the component classes (`DaggerFixtures_*.java`) are committed, not the per-binding factory classes.

## Measured result: bytes allocated per read of the whole map

Run on 2026-11-05 on one machine (macOS, Zulu 21). Every round printed the same number, except that round 1 of the 20-entry javax run printed 2256.3416. The raw output is in `results/`.

| Entries | Metro, javax `Provider` | Metro `Provider` | Dagger |
|---|---|---|---|
| 20 | 2,256 | 1,936 | 1,040 |
| 100 | 11,152 | 9,552 | 5,152 |

- Metro columns: `compiler-tests/src/test/data/box/upstream/Item5ProviderMapIncludedDeps{,100}{DaggerInterop,Metro}.kt`, run as `BoxTestGenerated` one test at a time on Metro main `2025f2b12`. Raw output: `results/metro-box.txt`.
- Dagger column: `./gradlew run` in this project. Raw output: `results/dagger.txt`.
- An earlier local run of a similar Dagger fixture printed 1,056 for 20 entries. The same fixture printed 1,040 when it ran alone in its own process, and 1,056 again when it ran after other Dagger fixtures in the same process, so the 16 B difference comes from the order of the measurements in one process. It does not come from the fixture or from fastInit. Every number in the table was measured with one fixture in its own process.

## Generated code

Metro, `Item5ProviderMapMetro`. A new map and a new factory per entry on every read:

`compiler-tests/src/test/data/dump/ir/upstream/Item5ProviderMapMetro.kt.txt:399-406`

```kotlin
    override val handlers: Map<String, Provider<Handler>>
      override get(): Map<String, Provider<Handler>> {
        return buildMap<String, Provider<Handler>>(capacity = 2, builderAction = local fun MutableMap<String, Provider<Handler>>.<anonymous>() {
          $receiver.put(key = "alpha", value = create(dep = <this>.#depProvider))
          $receiver.put(key = "beta", value = create(dep = <this>.#depProvider))
        }
)
      }
```

Dagger, `TwoEntryGraph`. A new map on every read, filled with providers that were created once:

`dagger-repro/item5/generated/DaggerFixtures_TwoEntryGraph.java:58-60,66`

```java
      MapBuilder mapBuilder = MapBuilder.<String, javax.inject.Provider<Fixtures.Handler>>newMapBuilder(2);
      mapBuilder.put("alpha", ((Provider) (alphaHandlerProvider)));
      mapBuilder.put("beta", ((Provider) (betaHandlerProvider)));
// ...
      this.alphaHandlerProvider = new SwitchingProvider<>(twoEntryGraphImpl, 0);
```

Metro, the first of 20 entries in `Item5ProviderMapIncludedDeps20Metro`. Each dependency gets a new anonymous provider on every read:

`compiler-tests/src/test/data/dump/ir/upstream/Item5ProviderMapIncludedDeps20Metro.kt.txt:480-492`

```kotlin
    override val handlers: Map<String, Provider<Handler>>
      override get(): Map<String, Provider<Handler>> {
        return buildMap<String, Provider<Handler>>(capacity = 20, builderAction = local fun MutableMap<String, Provider<Handler>>.<anonymous>() {
          $receiver.put(key = "h19", value = create(a = local fun <anonymous>(): D4 {
            return <this>.#depsInstance.<get-d4>()
          }
 /*-> Provider<D4> */, b = local fun <anonymous>(): D0 {
            return <this>.#depsInstance.<get-d0>()
          }
 /*-> Provider<D0> */, c = local fun <anonymous>(): D1 {
            return <this>.#depsInstance.<get-d1>()
          }
 /*-> Provider<D1> */))
```

Dagger, `Graph20`. The entries are fields, built once:

`dagger-repro/item5/generated/DaggerFixtures_Graph20.java:91-93,112,137`

```java
    Map mapOfStringAndProviderOfHandlerBuilder() {
      MapBuilder mapBuilder = MapBuilder.<String, javax.inject.Provider<Fixtures.Handler>>newMapBuilder(20);
      mapBuilder.put("h0", h0Provider);
// ...
      mapBuilder.put("h19", h19Provider);
// ...
      this.h19Provider = new SwitchingProvider<>(graph20Impl, 19);
```
