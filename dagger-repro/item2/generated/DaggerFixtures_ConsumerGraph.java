package repro;

import dagger.internal.DaggerGenerated;
import dagger.internal.Provider;
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
public final class DaggerFixtures_ConsumerGraph {
  private DaggerFixtures_ConsumerGraph() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static Fixtures.ConsumerGraph create() {
    return new Builder().build();
  }

  public static final class Builder {
    private Builder() {
    }

    public Fixtures.ConsumerGraph build() {
      return new ConsumerGraphImpl();
    }
  }

  private static final class ConsumerGraphImpl implements Fixtures.ConsumerGraph {
    private final ConsumerGraphImpl consumerGraphImpl = this;

    Provider<Fixtures.Foo> fooProvider;

    ConsumerGraphImpl() {

      initialize();

    }

    @SuppressWarnings("unchecked")
    private void initialize() {
      this.fooProvider = new SwitchingProvider<>(consumerGraphImpl, 0);
    }

    @Override
    public Fixtures.Consumer consumer() {
      return new Fixtures.Consumer(fooProvider, new Fixtures.Bar());
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final ConsumerGraphImpl consumerGraphImpl;

      private final int id;

      SwitchingProvider(ConsumerGraphImpl consumerGraphImpl, int id) {
        this.consumerGraphImpl = consumerGraphImpl;
        this.id = id;
      }

      @Override
      @SuppressWarnings("unchecked")
      public T get() {
        switch (id) {
          case 0: // repro.Fixtures.Foo
          return (T) new Fixtures.Foo(new Fixtures.Bar());

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
