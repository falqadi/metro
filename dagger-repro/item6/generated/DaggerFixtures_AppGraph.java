package repro;

import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Provider;
import java.util.Map;
import javax.annotation.processing.Generated;

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
public final class DaggerFixtures_AppGraph {
  private DaggerFixtures_AppGraph() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static Fixtures.AppGraph create() {
    return new Builder().build();
  }

  public static final class Builder {
    private Builder() {
    }

    public Fixtures.AppGraph build() {
      return new AppGraphImpl();
    }
  }

  private static final class AppGraphImpl implements Fixtures.AppGraph {
    private final AppGraphImpl appGraphImpl = this;

    Provider<Fixtures.Registry> registryProvider;

    AppGraphImpl() {

      initialize();

    }

    @SuppressWarnings("unchecked")
    private void initialize() {
      this.registryProvider = DoubleCheck.provider(new SwitchingProvider<Fixtures.Registry>(appGraphImpl, 0));
    }

    @Override
    public Map<String, javax.inject.Provider<Fixtures.Foo>> fooMap() {
      return Fixtures_Bindings_FooMapFactory.fooMap(registryProvider.get());
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final AppGraphImpl appGraphImpl;

      private final int id;

      SwitchingProvider(AppGraphImpl appGraphImpl, int id) {
        this.appGraphImpl = appGraphImpl;
        this.id = id;
      }

      @Override
      @SuppressWarnings("unchecked")
      public T get() {
        switch (id) {
          case 0: // repro.Fixtures.Registry
          return (T) Fixtures_Bindings_RegistryFactory.registry();

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
