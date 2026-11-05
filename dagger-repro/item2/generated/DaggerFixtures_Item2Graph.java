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
public final class DaggerFixtures_Item2Graph {
  private DaggerFixtures_Item2Graph() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static Fixtures.Item2Graph create() {
    return new Builder().build();
  }

  public static final class Builder {
    private Builder() {
    }

    public Fixtures.Item2Graph build() {
      return new Item2GraphImpl();
    }
  }

  private static final class Item2GraphImpl implements Fixtures.Item2Graph {
    private final Item2GraphImpl item2GraphImpl = this;

    Provider<Fixtures.Foo> fooProvider;

    Item2GraphImpl() {

      initialize();

    }

    @SuppressWarnings("unchecked")
    private void initialize() {
      this.fooProvider = new SwitchingProvider<>(item2GraphImpl, 0);
    }

    @Override
    public Fixtures.Foo foo() {
      return fooProvider.get();
    }

    @Override
    public javax.inject.Provider<Fixtures.Foo> fooProvider() {
      return fooProvider;
    }

    @Override
    public Fixtures.Consumer consumer() {
      return new Fixtures.Consumer(fooProvider, new Fixtures.Bar());
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final Item2GraphImpl item2GraphImpl;

      private final int id;

      SwitchingProvider(Item2GraphImpl item2GraphImpl, int id) {
        this.item2GraphImpl = item2GraphImpl;
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
