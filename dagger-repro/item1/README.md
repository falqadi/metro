# item1: Dagger reproducer for "Provider of a parent accessor is read while the child graph is built"

Metro side: the failing box test `compiler-tests/src/test/data/box/upstream/Item1ChildGraphProviderOfParentAccessor.kt` and its IR dump `compiler-tests/src/test/data/dump/ir/upstream/Item1ChildGraphProviderOfParentAccessor.kt.txt` on this branch.

The fixture is the same shape in Dagger. A parent component takes a dependency interface. A child subcomponent injects `Provider<Service>`, where `Service` comes from a parent dependency accessor. The program counts how often the accessor runs.

## Run

```
./gradlew run
```

Needs JDK 17 or newer and access to Maven Central. The project uses Dagger 2.60.1 (the version Metro main pins) as an annotation processor, with `-Adagger.fastInit=enabled`, Dagger's counterpart of Metro's switching providers. The generated Dagger source is in `build/generated/sources/annotationProcessor/java/main/repro/`.

## Expected output

```
accessor reads after the child is built: 0
accessor reads after two get() calls:    2
```

## Measured result

Run on 2026-11-05 (macOS, Zulu 21, Gradle 9.8.2, Dagger 2.60.1): the output above, exactly.

Dagger gives the child's consumer a provider field. The provider calls the parent accessor inside `get()`:

```java
return new Fixtures.Consumer(parentGraphImpl.serviceProvider);
// SwitchingProvider.get():
case 0: return (T) Preconditions.checkNotNullFromComponent(parentGraphImpl.parentDeps.service());
```

Metro calls the accessor while it builds the child, and wraps the value with `providerOf(...)`, so the same fixture reads the accessor once while building, and the box test fails at its first check ("accessor read 1 time(s) while building the child, expected 0").
