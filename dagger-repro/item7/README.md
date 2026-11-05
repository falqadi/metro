# item7: Dagger reproducer for "a provided Map<Class<*>, V> throws a ClassCastException with KClass interop"

Metro side: the box tests `compiler-tests/src/test/data/box/upstream/K*.kt`, run with the directives `ENABLE_KCLASS_TO_CLASS_INTEROP` and `ENABLE_DAGGER_INTEROP`, and the dump tests `compiler-tests/src/test/data/dump/ir/upstream/K1*.kt` and `K2*.kt` on this branch. K1, K4, K5 and K6 fail on the 4 JVM variants with `ClassCastException: class java.lang.Class cannot be cast to class kotlin.reflect.KClass`. K2 and K3 are controls and pass.

The Dagger fixture, `src/main/java/repro/Fixtures.java`, has the same shape: a plain `@Provides` method that returns `Map<Class<?>, Foo>`, a graph accessor for it, and a second binding that takes the map as a parameter. `Main` reads the map through both paths.

## Run

```
./gradlew run
```

Needs JDK 17 or newer and access to Maven Central. The project uses Dagger 2.60.1 (the version Metro main pins) as an annotation processor, with `-Adagger.fastInit=enabled`, Dagger's counterpart of Metro's switching providers.

The Dagger source that the processor generated is committed in `generated/`. It is the unedited output of Dagger 2.60.1 for `src/main/java/repro/Fixtures.java`, copied from `build/generated/sources/annotationProcessor/java/main/repro/`. Every code block in this file is an exact excerpt of a committed file, and the line numbers are given above each block.

## Measured result

Run on 2026-11-05 (macOS, Zulu 21, Gradle 9.8.2, Dagger 2.60.1): `accessor map contains Foo.class: true` and `injected map contains Foo.class: true`. No exception.

## Generated code

Metro, K1. The accessor wraps `Bindings.fooMap()` in `mapKeys<KClass<*>, ...>`, and the provided map already has `Class` keys:

`compiler-tests/src/test/data/dump/ir/upstream/K1ProvidedClassKeyedMap.kt.txt:21-26`

```kotlin
    override val fooMap: Map<Class<*>, Foo>
      override get(): Map<Class<*>, Foo> {
        return mapKeys<KClass<*>, Foo, Class<*>>(/* <this> = Bindings.fooMap(), */ transform = local fun <anonymous>(arg0: Map.Entry<KClass<*>, Foo>): Class<*> {
          return <get-java><Any?>(/* <this> = arg0.<get-key>() */)
        }
)
```

Dagger. The provided map is returned as it is, for the accessor and for the injected parameter:

`dagger-repro/item7/generated/DaggerFixtures_AppGraph.java:51-53,56-58`

```java
    public Map<Class<?>, Fixtures.Foo> fooMap() {
      return Fixtures_Bindings_FooMapFactory.fooMap();
    }
// ...
    public Fixtures.Holder holder() {
      return Fixtures_Bindings_HolderFactory.holder(Fixtures_Bindings_FooMapFactory.fooMap());
    }
```
