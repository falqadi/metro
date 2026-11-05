package repro;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Map;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class Fixtures_Bindings_FooMapFactory implements Factory<Map<String, Provider<Fixtures.Foo>>> {
  private final dagger.internal.Provider<Fixtures.Registry> registryProvider;

  private Fixtures_Bindings_FooMapFactory(
      dagger.internal.Provider<Fixtures.Registry> registryProvider) {
    this.registryProvider = registryProvider;
  }

  @Override
  public Map<String, Provider<Fixtures.Foo>> get() {
    return fooMap(registryProvider.get());
  }

  public static Fixtures_Bindings_FooMapFactory create(
      dagger.internal.Provider<Fixtures.Registry> registryProvider) {
    return new Fixtures_Bindings_FooMapFactory(registryProvider);
  }

  public static Map<String, Provider<Fixtures.Foo>> fooMap(Fixtures.Registry registry) {
    return Preconditions.checkNotNullFromProvides(Fixtures.Bindings.fooMap(registry));
  }
}
