package repro;

import dagger.internal.DaggerGenerated;
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

    AppGraphImpl() {


    }

    @Override
    public Map<Class<?>, Fixtures.Foo> fooMap() {
      return Fixtures_Bindings_FooMapFactory.fooMap();
    }

    @Override
    public Fixtures.Holder holder() {
      return Fixtures_Bindings_HolderFactory.holder(Fixtures_Bindings_FooMapFactory.fooMap());
    }
  }
}
