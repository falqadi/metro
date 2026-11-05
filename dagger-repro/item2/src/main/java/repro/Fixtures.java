package repro;

import dagger.Component;
import dagger.Module;
import dagger.Provides;
import javax.inject.Inject;
import javax.inject.Provider;

public final class Fixtures {
  private Fixtures() {}

  public static class Bar {
    @Inject public Bar() {}
  }

  public static class Foo {
    final Bar bar;

    @Inject public Foo(Bar bar) { this.bar = bar; }
  }

  public static class Consumer {
    final Provider<Foo> foo;
    final Bar bar;

    @Inject public Consumer(Provider<Foo> foo, Bar bar) {
      this.foo = foo;
      this.bar = bar;
    }
  }

  // The same shape as the Metro dump test Item2ProviderOfInjectClassInjected.kt.
  @Component
  public interface ConsumerGraph {
    Consumer consumer();
  }

  @Component
  public interface Item2Graph {
    Foo foo();
    Provider<Foo> fooProvider();
    Consumer consumer();
  }

  public static class FooP {
    final Bar bar;

    FooP(Bar bar) { this.bar = bar; }
  }

  public static class ConsumerP {
    final Provider<FooP> foo;
    final Bar bar;

    @Inject public ConsumerP(Provider<FooP> foo, Bar bar) {
      this.foo = foo;
      this.bar = bar;
    }
  }

  @Module
  public static class FooBindings {
    @Provides static FooP provideFoo(Bar bar) { return new FooP(bar); }
  }

  @Component(modules = FooBindings.class)
  public interface Item3Graph {
    FooP foo();
    Provider<FooP> fooProvider();
    ConsumerP consumer();
  }
}
