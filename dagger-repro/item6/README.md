# item6: Dagger reproducer for "a scoped binding behind a Provider-valued map"

Metro side: the box tests `compiler-tests/src/test/data/box/upstream/M*.kt` and the dump tests `compiler-tests/src/test/data/dump/ir/upstream/M*.kt` (with their `.kt.txt`) on this branch. M1 and M4 fail, M2, M3 and M5 pass.

The scope. In the Metro fixture the graph is declared with `@DependencyGraph(AppScope::class, ...)`, so its scope is `AppScope`, and `@SingleIn(AppScope::class)` on `registry()` means one `Registry` per graph instance (Metro's KDoc for `DependencyGraph` says a declared scope is an implicit `@SingleIn` of that scope). The Dagger equivalent is `@Singleton` on the component and on the provider. The box test reads the map twice from one graph.

Metro fixture M1:

`compiler-tests/src/test/data/box/upstream/M1ProvidedMapWithProviderValues.kt:1-17`

```kotlin
// IGNORE_BACKEND: JS_IR
// Expected to pass. Fails today: a @SingleIn binding used only by a plain @Provides that returns
// Map<K, Provider<V>> is inlined, so each read of the map creates a new Registry.
class Registry

class Foo(val registry: Registry)

@BindingContainer
object Bindings {
  @SingleIn(AppScope::class) @Provides fun registry(): Registry = Registry()
  @Provides fun fooMap(registry: Registry): Map<String, Provider<Foo>> = mapOf("a" to Provider { Foo(registry) })
}

@DependencyGraph(AppScope::class, bindingContainers = [Bindings::class])
interface AppGraph {
  val fooMap: Map<String, Provider<Foo>>
}
```

Dagger fixture, the same shape, with the scope lines:

`dagger-repro/item6/src/main/java/repro/Fixtures.java:22-36`

```java
  @Module
  public static class Bindings {
    @Singleton @Provides static Registry registry() { return new Registry(); }

    @Provides static Map<String, Provider<Foo>> fooMap(Registry registry) {
      return Collections.singletonMap("a", () -> new Foo(registry));
    }
  }

  @Singleton
  @Component(modules = Bindings.class)
  public interface AppGraph {
    Map<String, Provider<Foo>> fooMap();
  }
}
```

`Main` reads the map twice from one graph and checks that both `Foo`s hold the same `Registry`. It exits with code 1 if they differ.

## Run

```
./gradlew run
```

Needs JDK 17 or newer and access to Maven Central. The project uses Dagger 2.60.1 (the version Metro main pins) as an annotation processor, with `-Adagger.fastInit=enabled`, Dagger's counterpart of Metro's switching providers.

The Dagger source that the processor generated is committed in `generated/`. It is the unedited output of Dagger 2.60.1 for `src/main/java/repro/Fixtures.java`, copied from `build/generated/sources/annotationProcessor/java/main/repro/`. Every code block in this file is an exact excerpt of a committed file, and the line numbers are given above each block.

## Measured result

Run on 2026-11-05 (macOS, Zulu 21, Gradle 9.8.2, Dagger 2.60.1): `two reads of the map share one @Singleton Registry: true`, exit code 0.

## Generated code

Metro, M1. There is no provider field for `Registry`, so every read calls `registry()` again:

`compiler-tests/src/test/data/dump/ir/upstream/M1ProvidedMapWithProviderValues.kt.txt:34-37`

```kotlin
    override val fooMap: Map<String, Provider<Foo>>
      override get(): Map<String, Provider<Foo>> {
        return Bindings.fooMap(registry = Bindings.registry())
      }
```

Metro, M5, the same graph plus a `Foo` accessor. The field exists, and the map uses it:

`compiler-tests/src/test/data/dump/ir/upstream/M5ProvidedMapWithProviderValuesAndRegistryDependentAccessor.kt.txt:28-29,44`

```kotlin
    private val registryProvider: Provider<Registry>
      field = provider<Provider<Registry>, Registry>(delegate = create())
// ...
        return Bindings.fooMap(registry = <this>.#registryProvider.invoke())
```

Dagger. One cached provider:

`dagger-repro/item6/generated/DaggerFixtures_AppGraph.java:57,61-63`

```java
      this.registryProvider = DoubleCheck.provider(new SwitchingProvider<Fixtures.Registry>(appGraphImpl, 0));
// ...
    public Map<String, javax.inject.Provider<Fixtures.Foo>> fooMap() {
      return Fixtures_Bindings_FooMapFactory.fooMap(registryProvider.get());
    }
```
