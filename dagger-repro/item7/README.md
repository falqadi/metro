# item7: Dagger reproducer for "a provided Map<Class<*>, V> throws a ClassCastException with KClass interop"

Metro side: the box tests `compiler-tests/src/test/data/box/upstream/K*.kt` on this branch, run with the directives `ENABLE_KCLASS_TO_CLASS_INTEROP` and `ENABLE_DAGGER_INTEROP`. K1, K4, K5 and K6 fail on the 4 JVM variants with `ClassCastException: class java.lang.Class cannot be cast to class kotlin.reflect.KClass`. K2 and K3 are controls and pass.

The fixture is the same shape in Dagger: a plain `@Provides` method that returns `Map<Class<?>, Foo>`, a graph accessor for it, and a second binding that takes the map as a parameter. The program reads the map through both paths.

## Run

```
./gradlew run
```

Needs JDK 17 or newer and access to Maven Central. The project uses Dagger 2.60.1 (the version Metro main pins) as an annotation processor.

## Expected output

```
accessor map contains Foo.class: true
injected map contains Foo.class: true
```

## Measured result

Run on 2026-11-05 (macOS, Zulu 21, Gradle 9.8.2, Dagger 2.60.1): the output above, no exception.
