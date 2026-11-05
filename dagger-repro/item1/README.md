# item1: Dagger reproducer for "Provider of a parent accessor is read while the child graph is built"

Metro side: the failing box test `compiler-tests/src/test/data/box/upstream/Item1ChildGraphProviderOfParentAccessor.kt` and its IR dump `compiler-tests/src/test/data/dump/ir/upstream/Item1ChildGraphProviderOfParentAccessor.kt.txt` on this branch.

The Dagger fixture, `src/main/java/repro/Fixtures.java`, has the same shape. A parent component takes a dependency interface. A child subcomponent injects `Provider<Service>`, where `Service` comes from a parent dependency accessor. `Main` counts how often the accessor runs.

## Run

```
./gradlew run
```

Needs JDK 17 or newer and access to Maven Central. The project uses Dagger 2.60.1 (the version Metro main pins) as an annotation processor, with `-Adagger.fastInit=enabled`, Dagger's counterpart of Metro's switching providers.

The Dagger source that the processor generated is committed in `generated/`. It is the unedited output of Dagger 2.60.1 for `src/main/java/repro/Fixtures.java`, copied from `build/generated/sources/annotationProcessor/java/main/repro/`. Every code block in this file is an exact excerpt of a committed file, and the line numbers are given above each block.

## Measured result

Run on 2026-11-05 (macOS, Zulu 21, Gradle 9.8.2, Dagger 2.60.1):

- Accessor reads after the child is built: 0.
- Accessor reads after two `get()` calls: 2.

## Generated code

Metro. The child's consumer calls the parent accessor now, and wraps the value:

`compiler-tests/src/test/data/dump/ir/upstream/Item1ChildGraphProviderOfParentAccessor.kt.txt:140-143,157-160`

```kotlin
      override val consumer: Consumer
        override get(): Consumer {
          return Consumer(service = providerOf<Service>(value = <this>.#parentGraphImpl.<get-parentDepsService>()))
        }
// ...
    private val parentDepsService: Service
      private get(): Service {
        return <this>.#parentDepsInstance.<get-service>()
      }
```

Dagger. The child gets a provider field, and the accessor runs inside `get()`:

`dagger-repro/item1/generated/DaggerFixtures_ParentGraph.java:62-65,105-106`

```java
    @Override
    public Fixtures.Consumer consumer() {
      return new Fixtures.Consumer(parentGraphImpl.serviceProvider);
    }
// ...
          case 0: // repro.Fixtures.Service
          return (T) Preconditions.checkNotNullFromComponent(parentGraphImpl.parentDeps.service());
```
