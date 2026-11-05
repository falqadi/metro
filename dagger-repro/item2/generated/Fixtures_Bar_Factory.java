package repro;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
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
public final class Fixtures_Bar_Factory implements Factory<Fixtures.Bar> {
  @Override
  public Fixtures.Bar get() {
    return newInstance();
  }

  public static Fixtures_Bar_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static Fixtures.Bar newInstance() {
    return new Fixtures.Bar();
  }

  private static final class InstanceHolder {
    static final Fixtures_Bar_Factory INSTANCE = new Fixtures_Bar_Factory();
  }
}
