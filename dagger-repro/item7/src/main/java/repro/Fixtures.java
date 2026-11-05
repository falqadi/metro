package repro;

import dagger.Component;
import dagger.Module;
import dagger.Provides;
import java.util.Collections;
import java.util.Map;
import javax.inject.Singleton;

public final class Fixtures {
  private Fixtures() {}

  public static class Foo {}

  public static class Holder {
    final Map<Class<?>, Foo> map;

    Holder(Map<Class<?>, Foo> map) { this.map = map; }
  }

  @Module
  public static class Bindings {
    @Provides static Map<Class<?>, Foo> fooMap() {
      return Collections.singletonMap(Foo.class, new Foo());
    }

    @Provides static Holder holder(Map<Class<?>, Foo> map) { return new Holder(map); }
  }

  @Singleton
  @Component(modules = Bindings.class)
  public interface AppGraph {
    Map<Class<?>, Foo> fooMap();
    Holder holder();
  }
}
