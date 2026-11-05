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
  private final Provider<Fixtures.Service> serviceProvider;

  private Fixtures_Consumer_Factory(Provider<Fixtures.Service> serviceProvider) {
    this.serviceProvider = serviceProvider;
  }

  @Override
  public Fixtures.Consumer get() {
    return newInstance(serviceProvider);
  }

  public static Fixtures_Consumer_Factory create(Provider<Fixtures.Service> serviceProvider) {
    return new Fixtures_Consumer_Factory(serviceProvider);
  }

  public static Fixtures.Consumer newInstance(javax.inject.Provider<Fixtures.Service> service) {
    return new Fixtures.Consumer(service);
  }
}
