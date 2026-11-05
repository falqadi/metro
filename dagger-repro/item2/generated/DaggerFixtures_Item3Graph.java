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
public final class DaggerFixtures_Item3Graph {
  private DaggerFixtures_Item3Graph() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static Fixtures.Item3Graph create() {
    return new Builder().build();
  }

  public static final class Builder {
    private Builder() {
    }

    public Fixtures.Item3Graph build() {
      return new Item3GraphImpl();
    }
  }

  private static final class Item3GraphImpl implements Fixtures.Item3Graph {
    private final Item3GraphImpl item3GraphImpl = this;

    Provider<Fixtures.FooP> provideFooProvider;

    Item3GraphImpl() {

      initialize();

    }

    @SuppressWarnings("unchecked")
    private void initialize() {
      this.provideFooProvider = new SwitchingProvider<>(item3GraphImpl, 0);
    }

    @Override
    public Fixtures.FooP foo() {
      return provideFooProvider.get();
    }

    @Override
    public javax.inject.Provider<Fixtures.FooP> fooProvider() {
      return provideFooProvider;
    }

    @Override
    public Fixtures.ConsumerP consumer() {
      return new Fixtures.ConsumerP(provideFooProvider, new Fixtures.Bar());
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final Item3GraphImpl item3GraphImpl;

      private final int id;

      SwitchingProvider(Item3GraphImpl item3GraphImpl, int id) {
        this.item3GraphImpl = item3GraphImpl;
        this.id = id;
      }

      @Override
      @SuppressWarnings("unchecked")
      public T get() {
        switch (id) {
          case 0: // repro.Fixtures.FooP
          return (T) Fixtures_FooBindings_ProvideFooFactory.provideFoo(new Fixtures.Bar());

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
