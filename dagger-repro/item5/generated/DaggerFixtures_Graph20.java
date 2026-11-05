package repro;

import dagger.internal.DaggerGenerated;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
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
public final class DaggerFixtures_Graph20 {
  private DaggerFixtures_Graph20() {
  }

  public static Fixtures.Graph20.Factory factory() {
    return new Factory();
  }

  private static final class Factory implements Fixtures.Graph20.Factory {
    @Override
    public Fixtures.Graph20 create(Fixtures.Deps deps) {
      Preconditions.checkNotNull(deps);
      return new Graph20Impl(deps);
    }
  }

  private static final class Graph20Impl implements Fixtures.Graph20 {
    private final Fixtures.Deps deps;

    private final Graph20Impl graph20Impl = this;

    Provider<Fixtures.Handler> h0Provider;

    Provider<Fixtures.Handler> h1Provider;

    Provider<Fixtures.Handler> h2Provider;

    Provider<Fixtures.Handler> h3Provider;

    Provider<Fixtures.Handler> h4Provider;

    Provider<Fixtures.Handler> h5Provider;

    Provider<Fixtures.Handler> h6Provider;

    Provider<Fixtures.Handler> h7Provider;

    Provider<Fixtures.Handler> h8Provider;

    Provider<Fixtures.Handler> h9Provider;

    Provider<Fixtures.Handler> h10Provider;

    Provider<Fixtures.Handler> h11Provider;

    Provider<Fixtures.Handler> h12Provider;

    Provider<Fixtures.Handler> h13Provider;

    Provider<Fixtures.Handler> h14Provider;

    Provider<Fixtures.Handler> h15Provider;

    Provider<Fixtures.Handler> h16Provider;

    Provider<Fixtures.Handler> h17Provider;

    Provider<Fixtures.Handler> h18Provider;

    Provider<Fixtures.Handler> h19Provider;

    Graph20Impl(Fixtures.Deps depsParam) {
      this.deps = depsParam;
      initialize(depsParam);

    }

    Map mapOfStringAndProviderOfHandlerBuilder() {
      MapBuilder mapBuilder = MapBuilder.<String, javax.inject.Provider<Fixtures.Handler>>newMapBuilder(20);
      mapBuilder.put("h0", h0Provider);
      mapBuilder.put("h1", h1Provider);
      mapBuilder.put("h2", h2Provider);
      mapBuilder.put("h3", h3Provider);
      mapBuilder.put("h4", h4Provider);
      mapBuilder.put("h5", h5Provider);
      mapBuilder.put("h6", h6Provider);
      mapBuilder.put("h7", h7Provider);
      mapBuilder.put("h8", h8Provider);
      mapBuilder.put("h9", h9Provider);
      mapBuilder.put("h10", h10Provider);
      mapBuilder.put("h11", h11Provider);
      mapBuilder.put("h12", h12Provider);
      mapBuilder.put("h13", h13Provider);
      mapBuilder.put("h14", h14Provider);
      mapBuilder.put("h15", h15Provider);
      mapBuilder.put("h16", h16Provider);
      mapBuilder.put("h17", h17Provider);
      mapBuilder.put("h18", h18Provider);
      mapBuilder.put("h19", h19Provider);
      return mapBuilder.build();
    }

    @SuppressWarnings("unchecked")
    private void initialize(final Fixtures.Deps depsParam) {
      this.h0Provider = new SwitchingProvider<>(graph20Impl, 0);
      this.h1Provider = new SwitchingProvider<>(graph20Impl, 1);
      this.h2Provider = new SwitchingProvider<>(graph20Impl, 2);
      this.h3Provider = new SwitchingProvider<>(graph20Impl, 3);
      this.h4Provider = new SwitchingProvider<>(graph20Impl, 4);
      this.h5Provider = new SwitchingProvider<>(graph20Impl, 5);
      this.h6Provider = new SwitchingProvider<>(graph20Impl, 6);
      this.h7Provider = new SwitchingProvider<>(graph20Impl, 7);
      this.h8Provider = new SwitchingProvider<>(graph20Impl, 8);
      this.h9Provider = new SwitchingProvider<>(graph20Impl, 9);
      this.h10Provider = new SwitchingProvider<>(graph20Impl, 10);
      this.h11Provider = new SwitchingProvider<>(graph20Impl, 11);
      this.h12Provider = new SwitchingProvider<>(graph20Impl, 12);
      this.h13Provider = new SwitchingProvider<>(graph20Impl, 13);
      this.h14Provider = new SwitchingProvider<>(graph20Impl, 14);
      this.h15Provider = new SwitchingProvider<>(graph20Impl, 15);
      this.h16Provider = new SwitchingProvider<>(graph20Impl, 16);
      this.h17Provider = new SwitchingProvider<>(graph20Impl, 17);
      this.h18Provider = new SwitchingProvider<>(graph20Impl, 18);
      this.h19Provider = new SwitchingProvider<>(graph20Impl, 19);
    }

    @Override
    public Map<String, javax.inject.Provider<Fixtures.Handler>> handlers() {
      return mapOfStringAndProviderOfHandlerBuilder();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final Graph20Impl graph20Impl;

      private final int id;

      SwitchingProvider(Graph20Impl graph20Impl, int id) {
        this.graph20Impl = graph20Impl;
        this.id = id;
      }

      @Override
      @SuppressWarnings("unchecked")
      public T get() {
        switch (id) {
          case 0: // java.util.Map<java.lang.String,repro.Fixtures.Handler> repro.Fixtures.Handlers20#h0
          return (T) Fixtures_Handlers20_H0Factory.h0(Preconditions.checkNotNullFromComponent(graph20Impl.deps.d0()), Preconditions.checkNotNullFromComponent(graph20Impl.deps.d1()), Preconditions.checkNotNullFromComponent(graph20Impl.deps.d2()));

          case 1: // java.util.Map<java.lang.String,repro.Fixtures.Handler> repro.Fixtures.Handlers20#h1
          return (T) Fixtures_Handlers20_H1Factory.h1(Preconditions.checkNotNullFromComponent(graph20Impl.deps.d1()), Preconditions.checkNotNullFromComponent(graph20Impl.deps.d2()), Preconditions.checkNotNullFromComponent(graph20Impl.deps.d3()));

          case 2: // java.util.Map<java.lang.String,repro.Fixtures.Handler> repro.Fixtures.Handlers20#h2
          return (T) Fixtures_Handlers20_H2Factory.h2(Preconditions.checkNotNullFromComponent(graph20Impl.deps.d2()), Preconditions.checkNotNullFromComponent(graph20Impl.deps.d3()), Preconditions.checkNotNullFromComponent(graph20Impl.deps.d4()));

          case 3: // java.util.Map<java.lang.String,repro.Fixtures.Handler> repro.Fixtures.Handlers20#h3
          return (T) Fixtures_Handlers20_H3Factory.h3(Preconditions.checkNotNullFromComponent(graph20Impl.deps.d3()), Preconditions.checkNotNullFromComponent(graph20Impl.deps.d4()), Preconditions.checkNotNullFromComponent(graph20Impl.deps.d0()));

          case 4: // java.util.Map<java.lang.String,repro.Fixtures.Handler> repro.Fixtures.Handlers20#h4
          return (T) Fixtures_Handlers20_H4Factory.h4(Preconditions.checkNotNullFromComponent(graph20Impl.deps.d4()), Preconditions.checkNotNullFromComponent(graph20Impl.deps.d0()), Preconditions.checkNotNullFromComponent(graph20Impl.deps.d1()));

          case 5: // java.util.Map<java.lang.String,repro.Fixtures.Handler> repro.Fixtures.Handlers20#h5
          return (T) Fixtures_Handlers20_H5Factory.h5(Preconditions.checkNotNullFromComponent(graph20Impl.deps.d0()), Preconditions.checkNotNullFromComponent(graph20Impl.deps.d1()), Preconditions.checkNotNullFromComponent(graph20Impl.deps.d2()));

          case 6: // java.util.Map<java.lang.String,repro.Fixtures.Handler> repro.Fixtures.Handlers20#h6
          return (T) Fixtures_Handlers20_H6Factory.h6(Preconditions.checkNotNullFromComponent(graph20Impl.deps.d1()), Preconditions.checkNotNullFromComponent(graph20Impl.deps.d2()), Preconditions.checkNotNullFromComponent(graph20Impl.deps.d3()));

          case 7: // java.util.Map<java.lang.String,repro.Fixtures.Handler> repro.Fixtures.Handlers20#h7
          return (T) Fixtures_Handlers20_H7Factory.h7(Preconditions.checkNotNullFromComponent(graph20Impl.deps.d2()), Preconditions.checkNotNullFromComponent(graph20Impl.deps.d3()), Preconditions.checkNotNullFromComponent(graph20Impl.deps.d4()));

          case 8: // java.util.Map<java.lang.String,repro.Fixtures.Handler> repro.Fixtures.Handlers20#h8
          return (T) Fixtures_Handlers20_H8Factory.h8(Preconditions.checkNotNullFromComponent(graph20Impl.deps.d3()), Preconditions.checkNotNullFromComponent(graph20Impl.deps.d4()), Preconditions.checkNotNullFromComponent(graph20Impl.deps.d0()));

          case 9: // java.util.Map<java.lang.String,repro.Fixtures.Handler> repro.Fixtures.Handlers20#h9
          return (T) Fixtures_Handlers20_H9Factory.h9(Preconditions.checkNotNullFromComponent(graph20Impl.deps.d4()), Preconditions.checkNotNullFromComponent(graph20Impl.deps.d0()), Preconditions.checkNotNullFromComponent(graph20Impl.deps.d1()));

          case 10: // java.util.Map<java.lang.String,repro.Fixtures.Handler> repro.Fixtures.Handlers20#h10
          return (T) Fixtures_Handlers20_H10Factory.h10(Preconditions.checkNotNullFromComponent(graph20Impl.deps.d0()), Preconditions.checkNotNullFromComponent(graph20Impl.deps.d1()), Preconditions.checkNotNullFromComponent(graph20Impl.deps.d2()));

          case 11: // java.util.Map<java.lang.String,repro.Fixtures.Handler> repro.Fixtures.Handlers20#h11
          return (T) Fixtures_Handlers20_H11Factory.h11(Preconditions.checkNotNullFromComponent(graph20Impl.deps.d1()), Preconditions.checkNotNullFromComponent(graph20Impl.deps.d2()), Preconditions.checkNotNullFromComponent(graph20Impl.deps.d3()));

          case 12: // java.util.Map<java.lang.String,repro.Fixtures.Handler> repro.Fixtures.Handlers20#h12
          return (T) Fixtures_Handlers20_H12Factory.h12(Preconditions.checkNotNullFromComponent(graph20Impl.deps.d2()), Preconditions.checkNotNullFromComponent(graph20Impl.deps.d3()), Preconditions.checkNotNullFromComponent(graph20Impl.deps.d4()));

          case 13: // java.util.Map<java.lang.String,repro.Fixtures.Handler> repro.Fixtures.Handlers20#h13
          return (T) Fixtures_Handlers20_H13Factory.h13(Preconditions.checkNotNullFromComponent(graph20Impl.deps.d3()), Preconditions.checkNotNullFromComponent(graph20Impl.deps.d4()), Preconditions.checkNotNullFromComponent(graph20Impl.deps.d0()));

          case 14: // java.util.Map<java.lang.String,repro.Fixtures.Handler> repro.Fixtures.Handlers20#h14
          return (T) Fixtures_Handlers20_H14Factory.h14(Preconditions.checkNotNullFromComponent(graph20Impl.deps.d4()), Preconditions.checkNotNullFromComponent(graph20Impl.deps.d0()), Preconditions.checkNotNullFromComponent(graph20Impl.deps.d1()));

          case 15: // java.util.Map<java.lang.String,repro.Fixtures.Handler> repro.Fixtures.Handlers20#h15
          return (T) Fixtures_Handlers20_H15Factory.h15(Preconditions.checkNotNullFromComponent(graph20Impl.deps.d0()), Preconditions.checkNotNullFromComponent(graph20Impl.deps.d1()), Preconditions.checkNotNullFromComponent(graph20Impl.deps.d2()));

          case 16: // java.util.Map<java.lang.String,repro.Fixtures.Handler> repro.Fixtures.Handlers20#h16
          return (T) Fixtures_Handlers20_H16Factory.h16(Preconditions.checkNotNullFromComponent(graph20Impl.deps.d1()), Preconditions.checkNotNullFromComponent(graph20Impl.deps.d2()), Preconditions.checkNotNullFromComponent(graph20Impl.deps.d3()));

          case 17: // java.util.Map<java.lang.String,repro.Fixtures.Handler> repro.Fixtures.Handlers20#h17
          return (T) Fixtures_Handlers20_H17Factory.h17(Preconditions.checkNotNullFromComponent(graph20Impl.deps.d2()), Preconditions.checkNotNullFromComponent(graph20Impl.deps.d3()), Preconditions.checkNotNullFromComponent(graph20Impl.deps.d4()));

          case 18: // java.util.Map<java.lang.String,repro.Fixtures.Handler> repro.Fixtures.Handlers20#h18
          return (T) Fixtures_Handlers20_H18Factory.h18(Preconditions.checkNotNullFromComponent(graph20Impl.deps.d3()), Preconditions.checkNotNullFromComponent(graph20Impl.deps.d4()), Preconditions.checkNotNullFromComponent(graph20Impl.deps.d0()));

          case 19: // java.util.Map<java.lang.String,repro.Fixtures.Handler> repro.Fixtures.Handlers20#h19
          return (T) Fixtures_Handlers20_H19Factory.h19(Preconditions.checkNotNullFromComponent(graph20Impl.deps.d4()), Preconditions.checkNotNullFromComponent(graph20Impl.deps.d0()), Preconditions.checkNotNullFromComponent(graph20Impl.deps.d1()));

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
