package repro;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
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
public final class Fixtures_Bindings_RegistryFactory implements Factory<Fixtures.Registry> {
  @Override
  public Fixtures.Registry get() {
    return registry();
  }

  public static Fixtures_Bindings_RegistryFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static Fixtures.Registry registry() {
    return Preconditions.checkNotNullFromProvides(Fixtures.Bindings.registry());
  }

  private static final class InstanceHolder {
    static final Fixtures_Bindings_RegistryFactory INSTANCE = new Fixtures_Bindings_RegistryFactory();
  }
}
