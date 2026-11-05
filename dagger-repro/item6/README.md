# item6: Dagger reproducer for "a scoped binding behind a Provider-valued map"

Metro side: the box tests `compiler-tests/src/test/data/box/upstream/M*.kt` on this branch. M1 and M4 fail, M2, M3 and M5 pass. In Metro's IR dump for M1, the accessor is `Bindings.fooMap(registry = Bindings.registry())`, with no provider field for the scoped `Registry`.

The fixture is the same shape in Dagger: a `@Singleton @Provides` `Registry`, a plain `@Provides` method that takes it and returns `Map<String, Provider<Foo>>`, and a graph accessor for that map. The program reads the map twice and checks that both `Foo`s hold the same `Registry`. It exits with code 1 if they differ.

## Run

```
./gradlew run
```

Needs JDK 17 or newer and access to Maven Central. The project uses Dagger 2.60.1 (the version Metro main pins) as an annotation processor, with `-Adagger.fastInit=enabled`, Dagger's counterpart of Metro's switching providers. The generated Dagger source is in `build/generated/sources/annotationProcessor/java/main/repro/`.

## Expected output

```
two reads of the map share one @Singleton Registry: true
```

## Measured result

Run on 2026-11-05 (macOS, Zulu 21, Gradle 9.8.2, Dagger 2.60.1): the output above, exit code 0.

Dagger keeps the scoped binding in a cached provider:

```java
this.registryProvider = DoubleCheck.provider(new SwitchingProvider<Fixtures.Registry>(appGraphImpl, 0));
public Map<String, javax.inject.Provider<Fixtures.Foo>> fooMap() {
  return Fixtures_Bindings_FooMapFactory.fooMap(registryProvider.get());
}
```
