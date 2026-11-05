# item2: Dagger reproducer for "Provider requests create factory instances instead of direct construction"

Metro side: the dump tests `compiler-tests/src/test/data/dump/ir/upstream/Item2*.kt` and `Item3*.kt` with their `.kt.txt` dumps on this branch. In Metro's dump for `Item2ProviderOfInjectClassInjected`, the consumer is built as `Consumer(foo = create(bar = this.barProvider), bar = this.barProvider.invoke())`, a new factory on every call.

The fixture is the same shape in Dagger: a class that takes `Provider<Foo>` and `Bar`, a `Provider<Foo>` accessor, and the same with `Foo` coming from a `@Provides` method. The program prints the bytes allocated per call, after warm-up (`ThreadMXBean`, 20,000 warm-up calls, 3 rounds of 10,000).

## Run

```
./gradlew run
```

Needs JDK 17 or newer and access to Maven Central. The project uses Dagger 2.60.1 (the version Metro main pins) as an annotation processor, with `-Adagger.fastInit=enabled`, Dagger's counterpart of Metro's switching providers. The generated Dagger source is in `build/generated/sources/annotationProcessor/java/main/repro/`.

## Expected output

Every round of a line prints the same number:

| Call | Bytes per call |
|---|---|
| `foo()` (builds `Foo` and `Bar`) | 32 |
| `fooProvider()` (returns a field) | 0 |
| `consumer()` takes `Provider<Foo>` | 40 |
| `consumer()` with `Foo` from `@Provides` | 40 |

## Measured result

Run on 2026-11-05 (macOS, Zulu 21, Gradle 9.8.2, Dagger 2.60.1): 32.0, 0.0, 40.0 and 40.0 bytes per call, the same in all 3 rounds.

Dagger's generated code, which creates no factory object:

```java
public Fixtures.Consumer consumer() {
  return new Fixtures.Consumer(fooProvider, new Fixtures.Bar());
}
// SwitchingProvider.get():
case 0: return (T) new Fixtures.Foo(new Fixtures.Bar());
```
