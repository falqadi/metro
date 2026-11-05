# item5: Dagger reproducer for "Map<K, Provider<V>> is rebuilt with new factories on every read"

Metro side: the box tests `compiler-tests/src/test/data/box/upstream/Item5ProviderMapIncludedDeps*.kt` (they print the bytes allocated per read) and the dump tests `Item5ProviderMap*.kt` on this branch. In Metro's dump, the getter is `buildMap(capacity = 2) { put("alpha", create(dep = this.depProvider)) ... }`, a new factory per entry on every read.

The fixture is the same shape in Dagger: 20 `Handler` entries in a `Map<String, Provider<Handler>>`, each taking 3 dependencies from an included dependency interface. The program prints the bytes allocated per map read, after warm-up (`ThreadMXBean`, 20,000 warm-up reads, 3 rounds of 10,000).

## Run

```
./gradlew run
```

Needs JDK 17 or newer and access to Maven Central. The project uses Dagger 2.60.1 (the version Metro main pins) as an annotation processor, with `-Adagger.fastInit=enabled`, Dagger's counterpart of Metro's switching providers. The generated Dagger source is in `build/generated/sources/annotationProcessor/java/main/repro/`.

## Expected output

```
map entries: 20
Map<String, Provider<Handler>> read, 20 entries round 1: 1040.0 bytes allocated per call
Map<String, Provider<Handler>> read, 20 entries round 2: 1040.0 bytes allocated per call
Map<String, Provider<Handler>> read, 20 entries round 3: 1040.0 bytes allocated per call
```

## Measured result

Run on 2026-11-05 (macOS, Zulu 21, Gradle 9.8.2, Dagger 2.60.1): 1,040 bytes per map read in all 3 rounds.

Dagger builds the map from providers it created once and keeps in fields:

```java
MapBuilder mapBuilder = MapBuilder.<String, javax.inject.Provider<Fixtures.Handler>>newMapBuilder(20);
mapBuilder.put("h0", h0Provider);
mapBuilder.put("h1", h1Provider);
// ... 20 entries, each a field
return mapBuilder.build();
```
