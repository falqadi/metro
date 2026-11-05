package repro;

import dagger.Component;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import java.util.Map;
import javax.inject.Provider;

public final class Fixtures {
  private Fixtures() {}

  public interface Handler {}

  public static class D0 {}
  public static class D1 {}
  public static class D2 {}
  public static class D3 {}
  public static class D4 {}

  public interface Deps {
    D0 d0();
    D1 d1();
    D2 d2();
    D3 d3();
    D4 d4();
  }

  public static class H0 implements Handler { H0(D0 a, D1 b, D2 c) {} }
  public static class H1 implements Handler { H1(D1 a, D2 b, D3 c) {} }
  public static class H2 implements Handler { H2(D2 a, D3 b, D4 c) {} }
  public static class H3 implements Handler { H3(D3 a, D4 b, D0 c) {} }
  public static class H4 implements Handler { H4(D4 a, D0 b, D1 c) {} }
  public static class H5 implements Handler { H5(D0 a, D1 b, D2 c) {} }
  public static class H6 implements Handler { H6(D1 a, D2 b, D3 c) {} }
  public static class H7 implements Handler { H7(D2 a, D3 b, D4 c) {} }
  public static class H8 implements Handler { H8(D3 a, D4 b, D0 c) {} }
  public static class H9 implements Handler { H9(D4 a, D0 b, D1 c) {} }
  public static class H10 implements Handler { H10(D0 a, D1 b, D2 c) {} }
  public static class H11 implements Handler { H11(D1 a, D2 b, D3 c) {} }
  public static class H12 implements Handler { H12(D2 a, D3 b, D4 c) {} }
  public static class H13 implements Handler { H13(D3 a, D4 b, D0 c) {} }
  public static class H14 implements Handler { H14(D4 a, D0 b, D1 c) {} }
  public static class H15 implements Handler { H15(D0 a, D1 b, D2 c) {} }
  public static class H16 implements Handler { H16(D1 a, D2 b, D3 c) {} }
  public static class H17 implements Handler { H17(D2 a, D3 b, D4 c) {} }
  public static class H18 implements Handler { H18(D3 a, D4 b, D0 c) {} }
  public static class H19 implements Handler { H19(D4 a, D0 b, D1 c) {} }

  @Module
  public static class HandlerBindings {
    @Provides @IntoMap @StringKey("h0") static Handler h0(D0 a, D1 b, D2 c) { return new H0(a, b, c); }
    @Provides @IntoMap @StringKey("h1") static Handler h1(D1 a, D2 b, D3 c) { return new H1(a, b, c); }
    @Provides @IntoMap @StringKey("h2") static Handler h2(D2 a, D3 b, D4 c) { return new H2(a, b, c); }
    @Provides @IntoMap @StringKey("h3") static Handler h3(D3 a, D4 b, D0 c) { return new H3(a, b, c); }
    @Provides @IntoMap @StringKey("h4") static Handler h4(D4 a, D0 b, D1 c) { return new H4(a, b, c); }
    @Provides @IntoMap @StringKey("h5") static Handler h5(D0 a, D1 b, D2 c) { return new H5(a, b, c); }
    @Provides @IntoMap @StringKey("h6") static Handler h6(D1 a, D2 b, D3 c) { return new H6(a, b, c); }
    @Provides @IntoMap @StringKey("h7") static Handler h7(D2 a, D3 b, D4 c) { return new H7(a, b, c); }
    @Provides @IntoMap @StringKey("h8") static Handler h8(D3 a, D4 b, D0 c) { return new H8(a, b, c); }
    @Provides @IntoMap @StringKey("h9") static Handler h9(D4 a, D0 b, D1 c) { return new H9(a, b, c); }
    @Provides @IntoMap @StringKey("h10") static Handler h10(D0 a, D1 b, D2 c) { return new H10(a, b, c); }
    @Provides @IntoMap @StringKey("h11") static Handler h11(D1 a, D2 b, D3 c) { return new H11(a, b, c); }
    @Provides @IntoMap @StringKey("h12") static Handler h12(D2 a, D3 b, D4 c) { return new H12(a, b, c); }
    @Provides @IntoMap @StringKey("h13") static Handler h13(D3 a, D4 b, D0 c) { return new H13(a, b, c); }
    @Provides @IntoMap @StringKey("h14") static Handler h14(D4 a, D0 b, D1 c) { return new H14(a, b, c); }
    @Provides @IntoMap @StringKey("h15") static Handler h15(D0 a, D1 b, D2 c) { return new H15(a, b, c); }
    @Provides @IntoMap @StringKey("h16") static Handler h16(D1 a, D2 b, D3 c) { return new H16(a, b, c); }
    @Provides @IntoMap @StringKey("h17") static Handler h17(D2 a, D3 b, D4 c) { return new H17(a, b, c); }
    @Provides @IntoMap @StringKey("h18") static Handler h18(D3 a, D4 b, D0 c) { return new H18(a, b, c); }
    @Provides @IntoMap @StringKey("h19") static Handler h19(D4 a, D0 b, D1 c) { return new H19(a, b, c); }
  }

  @Component(dependencies = Deps.class, modules = HandlerBindings.class)
  public interface AppGraph {
    Map<String, Provider<Handler>> handlers();

    @Component.Factory
    interface Factory {
      AppGraph create(Deps deps);
    }
  }
}
