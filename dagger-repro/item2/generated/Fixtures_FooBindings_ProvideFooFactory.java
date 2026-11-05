package repro;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class Fixtures_FooBindings_ProvideFooFactory implements Factory<Fixtures.FooP> {
  private final Provider<Fixtures.Bar> barProvider;

  private Fixtures_FooBindings_ProvideFooFactory(Provider<Fixtures.Bar> barProvider) {
    this.barProvider = barProvider;
  }

  @Override
  public Fixtures.FooP get() {
    return provideFoo(barProvider.get());
  }

  public static Fixtures_FooBindings_ProvideFooFactory create(Provider<Fixtures.Bar> barProvider) {
    return new Fixtures_FooBindings_ProvideFooFactory(barProvider);
  }

  public static Fixtures.FooP provideFoo(Fixtures.Bar bar) {
    return Preconditions.checkNotNullFromProvides(Fixtures.FooBindings.provideFoo(bar));
  }
}
