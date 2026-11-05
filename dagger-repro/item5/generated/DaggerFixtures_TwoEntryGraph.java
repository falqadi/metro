package repro;

import dagger.internal.DaggerGenerated;
import dagger.internal.MapBuilder;
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
public final class DaggerFixtures_TwoEntryGraph {
  private DaggerFixtures_TwoEntryGraph() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static Fixtures.TwoEntryGraph create() {
    return new Builder().build();
  }

  public static final class Builder {
    private Builder() {
    }

    public Fixtures.TwoEntryGraph build() {
      return new TwoEntryGraphImpl();
    }
  }

  private static final class TwoEntryGraphImpl implements Fixtures.TwoEntryGraph {
    private final TwoEntryGraphImpl twoEntryGraphImpl = this;

    Provider<Fixtures.AlphaHandler> alphaHandlerProvider;

    Provider<Fixtures.BetaHandler> betaHandlerProvider;

    TwoEntryGraphImpl() {

      initialize();

    }

    Map mapOfStringAndProviderOfHandlerBuilder() {
      MapBuilder mapBuilder = MapBuilder.<String, javax.inject.Provider<Fixtures.Handler>>newMapBuilder(2);
      mapBuilder.put("alpha", ((Provider) (alphaHandlerProvider)));
      mapBuilder.put("beta", ((Provider) (betaHandlerProvider)));
      return mapBuilder.build();
    }

    @SuppressWarnings("unchecked")
    private void initialize() {
      this.alphaHandlerProvider = new SwitchingProvider<>(twoEntryGraphImpl, 0);
      this.betaHandlerProvider = new SwitchingProvider<>(twoEntryGraphImpl, 1);
    }

    @Override
    public Map<String, javax.inject.Provider<Fixtures.Handler>> handlers() {
      return mapOfStringAndProviderOfHandlerBuilder();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final TwoEntryGraphImpl twoEntryGraphImpl;

      private final int id;

      SwitchingProvider(TwoEntryGraphImpl twoEntryGraphImpl, int id) {
        this.twoEntryGraphImpl = twoEntryGraphImpl;
        this.id = id;
      }

      @Override
      @SuppressWarnings("unchecked")
      public T get() {
        switch (id) {
          case 0: // repro.Fixtures.AlphaHandler
          return (T) new Fixtures.AlphaHandler(new Fixtures.Dep());

          case 1: // repro.Fixtures.BetaHandler
          return (T) new Fixtures.BetaHandler(new Fixtures.Dep());

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
