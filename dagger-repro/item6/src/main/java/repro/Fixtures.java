package repro;

import dagger.Component;
import dagger.Module;
import dagger.Provides;
import java.util.Collections;
import java.util.Map;
import javax.inject.Provider;
import javax.inject.Singleton;

public final class Fixtures {
  private Fixtures() {}

  public static class Registry {}

  public static class Foo {
    final Registry registry;

    Foo(Registry registry) { this.registry = registry; }
  }

  @Module
  public static class Bindings {
    @Singleton @Provides static Registry registry() { return new Registry(); }

    @Provides static Map<String, Provider<Foo>> fooMap(Registry registry) {
      return Collections.singletonMap("a", () -> new Foo(registry));
    }
  }

  @Singleton
  @Component(modules = Bindings.class)
  public interface AppGraph {
    Map<String, Provider<Foo>> fooMap();
  }
}
