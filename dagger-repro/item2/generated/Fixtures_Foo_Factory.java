package repro;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
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
public final class Fixtures_Foo_Factory implements Factory<Fixtures.Foo> {
  private final Provider<Fixtures.Bar> barProvider;

  private Fixtures_Foo_Factory(Provider<Fixtures.Bar> barProvider) {
    this.barProvider = barProvider;
  }

  @Override
  public Fixtures.Foo get() {
    return newInstance(barProvider.get());
  }

  public static Fixtures_Foo_Factory create(Provider<Fixtures.Bar> barProvider) {
    return new Fixtures_Foo_Factory(barProvider);
  }

  public static Fixtures.Foo newInstance(Fixtures.Bar bar) {
    return new Fixtures.Foo(bar);
  }
}
