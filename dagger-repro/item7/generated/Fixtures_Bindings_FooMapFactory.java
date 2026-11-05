package repro;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Map;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata
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
public final class Fixtures_Bindings_FooMapFactory implements Factory<Map<Class<?>, Fixtures.Foo>> {
  @Override
  public Map<Class<?>, Fixtures.Foo> get() {
    return fooMap();
  }

  public static Fixtures_Bindings_FooMapFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static Map<Class<?>, Fixtures.Foo> fooMap() {
    return Preconditions.checkNotNullFromProvides(Fixtures.Bindings.fooMap());
  }

  private static final class InstanceHolder {
    static final Fixtures_Bindings_FooMapFactory INSTANCE = new Fixtures_Bindings_FooMapFactory();
  }
}
