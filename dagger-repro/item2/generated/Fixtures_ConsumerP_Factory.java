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
public final class Fixtures_ConsumerP_Factory implements Factory<Fixtures.ConsumerP> {
  private final Provider<Fixtures.FooP> fooProvider;

  private final Provider<Fixtures.Bar> barProvider;

  private Fixtures_ConsumerP_Factory(Provider<Fixtures.FooP> fooProvider,
      Provider<Fixtures.Bar> barProvider) {
    this.fooProvider = fooProvider;
    this.barProvider = barProvider;
  }

  @Override
  public Fixtures.ConsumerP get() {
    return newInstance(fooProvider, barProvider.get());
  }

  public static Fixtures_ConsumerP_Factory create(Provider<Fixtures.FooP> fooProvider,
      Provider<Fixtures.Bar> barProvider) {
    return new Fixtures_ConsumerP_Factory(fooProvider, barProvider);
  }

  public static Fixtures.ConsumerP newInstance(javax.inject.Provider<Fixtures.FooP> foo,
      Fixtures.Bar bar) {
    return new Fixtures.ConsumerP(foo, bar);
  }
}
