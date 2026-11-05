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
public final class Fixtures_Consumer_Factory implements Factory<Fixtures.Consumer> {
  private final Provider<Fixtures.Foo> fooProvider;

  private final Provider<Fixtures.Bar> barProvider;

  private Fixtures_Consumer_Factory(Provider<Fixtures.Foo> fooProvider,
      Provider<Fixtures.Bar> barProvider) {
    this.fooProvider = fooProvider;
    this.barProvider = barProvider;
  }

  @Override
  public Fixtures.Consumer get() {
    return newInstance(fooProvider, barProvider.get());
  }

  public static Fixtures_Consumer_Factory create(Provider<Fixtures.Foo> fooProvider,
      Provider<Fixtures.Bar> barProvider) {
    return new Fixtures_Consumer_Factory(fooProvider, barProvider);
  }

  public static Fixtures.Consumer newInstance(javax.inject.Provider<Fixtures.Foo> foo,
      Fixtures.Bar bar) {
    return new Fixtures.Consumer(foo, bar);
  }
}
