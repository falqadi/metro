# item2: Dagger reproducer for "Provider requests create factory instances instead of direct construction"

Metro side: the dump tests `compiler-tests/src/test/data/dump/ir/upstream/Item2*.kt` and `Item3*.kt` with their `.kt.txt` dumps on this branch.

The Dagger fixture, `src/main/java/repro/Fixtures.java`, has the same shape. `ConsumerGraph` matches the Metro test `Item2ProviderOfInjectClassInjected.kt`: a class that takes `Provider<Foo>` and `Bar`. `Item2Graph` and `Item3Graph` also have `Provider<Foo>` accessors, and `Foo` coming from a `@Provides` method. `Main` prints the bytes allocated per call, after warm-up (`ThreadMXBean`, 20,000 warm-up calls, then 3 rounds of 10,000 calls).

## Run

```
./gradlew run
```

Needs JDK 17 or newer and access to Maven Central. The project uses Dagger 2.60.1 (the version Metro main pins) as an annotation processor, with `-Adagger.fastInit=enabled`, Dagger's counterpart of Metro's switching providers.

The Dagger source that the processor generated is committed in `generated/`. It is the unedited output of Dagger 2.60.1 for `src/main/java/repro/Fixtures.java`, copied from `build/generated/sources/annotationProcessor/java/main/repro/`. Every code block in this file is an exact excerpt of a committed file, and the line numbers are given above each block.

## Measured result

Run on 2026-11-05 (macOS, Zulu 21, Gradle 9.8.2, Dagger 2.60.1). Every round of a line printed the same number:

| Call | Bytes per call |
|---|---|
| `Item2Graph.foo()` | 32 |
| `Item2Graph.fooProvider()` | 0 |
| `Item2Graph.consumer()`, takes `Provider<Foo>` | 40 |
| `Item3Graph.consumer()`, `Foo` from `@Provides` | 40 |

## Generated code

Metro, `Item2ProviderOfInjectClassInjected`. The consumer is built with a new factory on every call:

`compiler-tests/src/test/data/dump/ir/upstream/Item2ProviderOfInjectClassInjected.kt.txt:208-211`

```kotlin
    override val consumer: Consumer
      override get(): Consumer {
        return Consumer(foo = create(bar = <this>.#barProvider), bar = <this>.#barProvider.invoke())
      }
```

Metro, `Item2JavaxProviderAccessor`. A `javax.inject.Provider` accessor creates and wraps a new factory on every call:

`compiler-tests/src/test/data/dump/ir/upstream/Item2JavaxProviderAccessor.kt.txt:162-165`

```kotlin
    override val fooProvider: Provider<Foo>
      override get(): Provider<Foo> {
        return asJavaxProvider<Foo>(/* <this> = create(bar = create()) */)
      }
```

Dagger, `ConsumerGraph`. The consumer gets the provider field and a new `Bar`, and the switch calls the constructor:

`dagger-repro/item2/generated/DaggerFixtures_ConsumerGraph.java:58-61,77-78`

```java
    @Override
    public Fixtures.Consumer consumer() {
      return new Fixtures.Consumer(fooProvider, new Fixtures.Bar());
    }
// ...
          case 0: // repro.Fixtures.Foo
          return (T) new Fixtures.Foo(new Fixtures.Bar());
```
