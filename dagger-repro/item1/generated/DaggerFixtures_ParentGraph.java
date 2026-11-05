package repro;

import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
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
public final class DaggerFixtures_ParentGraph {
  private DaggerFixtures_ParentGraph() {
  }

  public static Fixtures.ParentGraph.Factory factory() {
    return new Factory();
  }

  private static final class Factory implements Fixtures.ParentGraph.Factory {
    @Override
    public Fixtures.ParentGraph create(Fixtures.ParentDeps deps) {
      Preconditions.checkNotNull(deps);
      return new ParentGraphImpl(deps);
    }
  }

  private static final class ChildGraphFactory implements Fixtures.ChildGraph.Factory {
    private final ParentGraphImpl parentGraphImpl;

    private ChildGraphFactory(ParentGraphImpl parentGraphImpl) {
      this.parentGraphImpl = parentGraphImpl;
    }

    @Override
    public Fixtures.ChildGraph create() {
      return new ChildGraphImpl(parentGraphImpl);
    }
  }

  private static final class ChildGraphImpl implements Fixtures.ChildGraph {
    private final ParentGraphImpl parentGraphImpl;

    private final ChildGraphImpl childGraphImpl = this;

    ChildGraphImpl(ParentGraphImpl parentGraphImpl) {
      this.parentGraphImpl = parentGraphImpl;


    }

    @Override
    public Fixtures.Consumer consumer() {
      return new Fixtures.Consumer(parentGraphImpl.serviceProvider);
    }
  }

  private static final class ParentGraphImpl implements Fixtures.ParentGraph {
    private final Fixtures.ParentDeps parentDeps;

    private final ParentGraphImpl parentGraphImpl = this;

    Provider<Fixtures.Service> serviceProvider;

    ParentGraphImpl(Fixtures.ParentDeps parentDepsParam) {
      this.parentDeps = parentDepsParam;
      initialize(parentDepsParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final Fixtures.ParentDeps parentDepsParam) {
      this.serviceProvider = new SwitchingProvider<>(parentGraphImpl, 0);
    }

    @Override
    public Fixtures.ChildGraph.Factory childFactory() {
      return new ChildGraphFactory(parentGraphImpl);
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final ParentGraphImpl parentGraphImpl;

      private final int id;

      SwitchingProvider(ParentGraphImpl parentGraphImpl, int id) {
        this.parentGraphImpl = parentGraphImpl;
        this.id = id;
      }

      @Override
      @SuppressWarnings("unchecked")
      public T get() {
        switch (id) {
          case 0: // repro.Fixtures.Service
          return (T) Preconditions.checkNotNullFromComponent(parentGraphImpl.parentDeps.service());

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
