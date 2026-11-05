package repro;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Map;
import javax.annotation.processing.Generated;

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
public final class Fixtures_Bindings_HolderFactory implements Factory<Fixtures.Holder> {
  private final Provider<Map<Class<?>, Fixtures.Foo>> mapProvider;

  private Fixtures_Bindings_HolderFactory(Provider<Map<Class<?>, Fixtures.Foo>> mapProvider) {
    this.mapProvider = mapProvider;
  }

  @Override
  public Fixtures.Holder get() {
    return holder(mapProvider.get());
  }

  public static Fixtures_Bindings_HolderFactory create(
      Provider<Map<Class<?>, Fixtures.Foo>> mapProvider) {
    return new Fixtures_Bindings_HolderFactory(mapProvider);
  }

  public static Fixtures.Holder holder(Map<Class<?>, Fixtures.Foo> map) {
    return Preconditions.checkNotNullFromProvides(Fixtures.Bindings.holder(map));
  }
}
