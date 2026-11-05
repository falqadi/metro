package repro;

import dagger.Binds;
import dagger.Component;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

public final class Fixtures {
  private Fixtures() {}

  public interface Handler {}

  // Two entries, the same shape as the Metro dump test Item5ProviderMapMetro.kt.
  public static class Dep {
    @Inject public Dep() {}
  }

  public static class AlphaHandler implements Handler {
    @Inject public AlphaHandler(Dep dep) {}
  }

  public static class BetaHandler implements Handler {
    @Inject public BetaHandler(Dep dep) {}
  }

  @Module
  public interface TwoEntryBindings {
    @Binds @IntoMap @StringKey("alpha") Handler alpha(AlphaHandler handler);

    @Binds @IntoMap @StringKey("beta") Handler beta(BetaHandler handler);
  }

  @Component(modules = TwoEntryBindings.class)
  public interface TwoEntryGraph {
    Map<String, Provider<Handler>> handlers();
  }

  // Every entry takes 3 dependencies from an included dependency interface, the same shape as the
  // Metro box tests Item5ProviderMapIncludedDeps*.kt.
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

  public static class H20_0 implements Handler { H20_0(D0 a, D1 b, D2 c) {} }
  public static class H20_1 implements Handler { H20_1(D1 a, D2 b, D3 c) {} }
  public static class H20_2 implements Handler { H20_2(D2 a, D3 b, D4 c) {} }
  public static class H20_3 implements Handler { H20_3(D3 a, D4 b, D0 c) {} }
  public static class H20_4 implements Handler { H20_4(D4 a, D0 b, D1 c) {} }
  public static class H20_5 implements Handler { H20_5(D0 a, D1 b, D2 c) {} }
  public static class H20_6 implements Handler { H20_6(D1 a, D2 b, D3 c) {} }
  public static class H20_7 implements Handler { H20_7(D2 a, D3 b, D4 c) {} }
  public static class H20_8 implements Handler { H20_8(D3 a, D4 b, D0 c) {} }
  public static class H20_9 implements Handler { H20_9(D4 a, D0 b, D1 c) {} }
  public static class H20_10 implements Handler { H20_10(D0 a, D1 b, D2 c) {} }
  public static class H20_11 implements Handler { H20_11(D1 a, D2 b, D3 c) {} }
  public static class H20_12 implements Handler { H20_12(D2 a, D3 b, D4 c) {} }
  public static class H20_13 implements Handler { H20_13(D3 a, D4 b, D0 c) {} }
  public static class H20_14 implements Handler { H20_14(D4 a, D0 b, D1 c) {} }
  public static class H20_15 implements Handler { H20_15(D0 a, D1 b, D2 c) {} }
  public static class H20_16 implements Handler { H20_16(D1 a, D2 b, D3 c) {} }
  public static class H20_17 implements Handler { H20_17(D2 a, D3 b, D4 c) {} }
  public static class H20_18 implements Handler { H20_18(D3 a, D4 b, D0 c) {} }
  public static class H20_19 implements Handler { H20_19(D4 a, D0 b, D1 c) {} }

  @Module
  public static class Handlers20 {
    @Provides @IntoMap @StringKey("h0") static Handler h0(D0 a, D1 b, D2 c) { return new H20_0(a, b, c); }
    @Provides @IntoMap @StringKey("h1") static Handler h1(D1 a, D2 b, D3 c) { return new H20_1(a, b, c); }
    @Provides @IntoMap @StringKey("h2") static Handler h2(D2 a, D3 b, D4 c) { return new H20_2(a, b, c); }
    @Provides @IntoMap @StringKey("h3") static Handler h3(D3 a, D4 b, D0 c) { return new H20_3(a, b, c); }
    @Provides @IntoMap @StringKey("h4") static Handler h4(D4 a, D0 b, D1 c) { return new H20_4(a, b, c); }
    @Provides @IntoMap @StringKey("h5") static Handler h5(D0 a, D1 b, D2 c) { return new H20_5(a, b, c); }
    @Provides @IntoMap @StringKey("h6") static Handler h6(D1 a, D2 b, D3 c) { return new H20_6(a, b, c); }
    @Provides @IntoMap @StringKey("h7") static Handler h7(D2 a, D3 b, D4 c) { return new H20_7(a, b, c); }
    @Provides @IntoMap @StringKey("h8") static Handler h8(D3 a, D4 b, D0 c) { return new H20_8(a, b, c); }
    @Provides @IntoMap @StringKey("h9") static Handler h9(D4 a, D0 b, D1 c) { return new H20_9(a, b, c); }
    @Provides @IntoMap @StringKey("h10") static Handler h10(D0 a, D1 b, D2 c) { return new H20_10(a, b, c); }
    @Provides @IntoMap @StringKey("h11") static Handler h11(D1 a, D2 b, D3 c) { return new H20_11(a, b, c); }
    @Provides @IntoMap @StringKey("h12") static Handler h12(D2 a, D3 b, D4 c) { return new H20_12(a, b, c); }
    @Provides @IntoMap @StringKey("h13") static Handler h13(D3 a, D4 b, D0 c) { return new H20_13(a, b, c); }
    @Provides @IntoMap @StringKey("h14") static Handler h14(D4 a, D0 b, D1 c) { return new H20_14(a, b, c); }
    @Provides @IntoMap @StringKey("h15") static Handler h15(D0 a, D1 b, D2 c) { return new H20_15(a, b, c); }
    @Provides @IntoMap @StringKey("h16") static Handler h16(D1 a, D2 b, D3 c) { return new H20_16(a, b, c); }
    @Provides @IntoMap @StringKey("h17") static Handler h17(D2 a, D3 b, D4 c) { return new H20_17(a, b, c); }
    @Provides @IntoMap @StringKey("h18") static Handler h18(D3 a, D4 b, D0 c) { return new H20_18(a, b, c); }
    @Provides @IntoMap @StringKey("h19") static Handler h19(D4 a, D0 b, D1 c) { return new H20_19(a, b, c); }
  }

  @Component(dependencies = Deps.class, modules = Handlers20.class)
  public interface Graph20 {
    Map<String, Provider<Handler>> handlers();

    @Component.Factory
    interface Factory {
      Graph20 create(Deps deps);
    }
  }

  public static class H100_0 implements Handler { H100_0(D0 a, D1 b, D2 c) {} }
  public static class H100_1 implements Handler { H100_1(D1 a, D2 b, D3 c) {} }
  public static class H100_2 implements Handler { H100_2(D2 a, D3 b, D4 c) {} }
  public static class H100_3 implements Handler { H100_3(D3 a, D4 b, D0 c) {} }
  public static class H100_4 implements Handler { H100_4(D4 a, D0 b, D1 c) {} }
  public static class H100_5 implements Handler { H100_5(D0 a, D1 b, D2 c) {} }
  public static class H100_6 implements Handler { H100_6(D1 a, D2 b, D3 c) {} }
  public static class H100_7 implements Handler { H100_7(D2 a, D3 b, D4 c) {} }
  public static class H100_8 implements Handler { H100_8(D3 a, D4 b, D0 c) {} }
  public static class H100_9 implements Handler { H100_9(D4 a, D0 b, D1 c) {} }
  public static class H100_10 implements Handler { H100_10(D0 a, D1 b, D2 c) {} }
  public static class H100_11 implements Handler { H100_11(D1 a, D2 b, D3 c) {} }
  public static class H100_12 implements Handler { H100_12(D2 a, D3 b, D4 c) {} }
  public static class H100_13 implements Handler { H100_13(D3 a, D4 b, D0 c) {} }
  public static class H100_14 implements Handler { H100_14(D4 a, D0 b, D1 c) {} }
  public static class H100_15 implements Handler { H100_15(D0 a, D1 b, D2 c) {} }
  public static class H100_16 implements Handler { H100_16(D1 a, D2 b, D3 c) {} }
  public static class H100_17 implements Handler { H100_17(D2 a, D3 b, D4 c) {} }
  public static class H100_18 implements Handler { H100_18(D3 a, D4 b, D0 c) {} }
  public static class H100_19 implements Handler { H100_19(D4 a, D0 b, D1 c) {} }
  public static class H100_20 implements Handler { H100_20(D0 a, D1 b, D2 c) {} }
  public static class H100_21 implements Handler { H100_21(D1 a, D2 b, D3 c) {} }
  public static class H100_22 implements Handler { H100_22(D2 a, D3 b, D4 c) {} }
  public static class H100_23 implements Handler { H100_23(D3 a, D4 b, D0 c) {} }
  public static class H100_24 implements Handler { H100_24(D4 a, D0 b, D1 c) {} }
  public static class H100_25 implements Handler { H100_25(D0 a, D1 b, D2 c) {} }
  public static class H100_26 implements Handler { H100_26(D1 a, D2 b, D3 c) {} }
  public static class H100_27 implements Handler { H100_27(D2 a, D3 b, D4 c) {} }
  public static class H100_28 implements Handler { H100_28(D3 a, D4 b, D0 c) {} }
  public static class H100_29 implements Handler { H100_29(D4 a, D0 b, D1 c) {} }
  public static class H100_30 implements Handler { H100_30(D0 a, D1 b, D2 c) {} }
  public static class H100_31 implements Handler { H100_31(D1 a, D2 b, D3 c) {} }
  public static class H100_32 implements Handler { H100_32(D2 a, D3 b, D4 c) {} }
  public static class H100_33 implements Handler { H100_33(D3 a, D4 b, D0 c) {} }
  public static class H100_34 implements Handler { H100_34(D4 a, D0 b, D1 c) {} }
  public static class H100_35 implements Handler { H100_35(D0 a, D1 b, D2 c) {} }
  public static class H100_36 implements Handler { H100_36(D1 a, D2 b, D3 c) {} }
  public static class H100_37 implements Handler { H100_37(D2 a, D3 b, D4 c) {} }
  public static class H100_38 implements Handler { H100_38(D3 a, D4 b, D0 c) {} }
  public static class H100_39 implements Handler { H100_39(D4 a, D0 b, D1 c) {} }
  public static class H100_40 implements Handler { H100_40(D0 a, D1 b, D2 c) {} }
  public static class H100_41 implements Handler { H100_41(D1 a, D2 b, D3 c) {} }
  public static class H100_42 implements Handler { H100_42(D2 a, D3 b, D4 c) {} }
  public static class H100_43 implements Handler { H100_43(D3 a, D4 b, D0 c) {} }
  public static class H100_44 implements Handler { H100_44(D4 a, D0 b, D1 c) {} }
  public static class H100_45 implements Handler { H100_45(D0 a, D1 b, D2 c) {} }
  public static class H100_46 implements Handler { H100_46(D1 a, D2 b, D3 c) {} }
  public static class H100_47 implements Handler { H100_47(D2 a, D3 b, D4 c) {} }
  public static class H100_48 implements Handler { H100_48(D3 a, D4 b, D0 c) {} }
  public static class H100_49 implements Handler { H100_49(D4 a, D0 b, D1 c) {} }
  public static class H100_50 implements Handler { H100_50(D0 a, D1 b, D2 c) {} }
  public static class H100_51 implements Handler { H100_51(D1 a, D2 b, D3 c) {} }
  public static class H100_52 implements Handler { H100_52(D2 a, D3 b, D4 c) {} }
  public static class H100_53 implements Handler { H100_53(D3 a, D4 b, D0 c) {} }
  public static class H100_54 implements Handler { H100_54(D4 a, D0 b, D1 c) {} }
  public static class H100_55 implements Handler { H100_55(D0 a, D1 b, D2 c) {} }
  public static class H100_56 implements Handler { H100_56(D1 a, D2 b, D3 c) {} }
  public static class H100_57 implements Handler { H100_57(D2 a, D3 b, D4 c) {} }
  public static class H100_58 implements Handler { H100_58(D3 a, D4 b, D0 c) {} }
  public static class H100_59 implements Handler { H100_59(D4 a, D0 b, D1 c) {} }
  public static class H100_60 implements Handler { H100_60(D0 a, D1 b, D2 c) {} }
  public static class H100_61 implements Handler { H100_61(D1 a, D2 b, D3 c) {} }
  public static class H100_62 implements Handler { H100_62(D2 a, D3 b, D4 c) {} }
  public static class H100_63 implements Handler { H100_63(D3 a, D4 b, D0 c) {} }
  public static class H100_64 implements Handler { H100_64(D4 a, D0 b, D1 c) {} }
  public static class H100_65 implements Handler { H100_65(D0 a, D1 b, D2 c) {} }
  public static class H100_66 implements Handler { H100_66(D1 a, D2 b, D3 c) {} }
  public static class H100_67 implements Handler { H100_67(D2 a, D3 b, D4 c) {} }
  public static class H100_68 implements Handler { H100_68(D3 a, D4 b, D0 c) {} }
  public static class H100_69 implements Handler { H100_69(D4 a, D0 b, D1 c) {} }
  public static class H100_70 implements Handler { H100_70(D0 a, D1 b, D2 c) {} }
  public static class H100_71 implements Handler { H100_71(D1 a, D2 b, D3 c) {} }
  public static class H100_72 implements Handler { H100_72(D2 a, D3 b, D4 c) {} }
  public static class H100_73 implements Handler { H100_73(D3 a, D4 b, D0 c) {} }
  public static class H100_74 implements Handler { H100_74(D4 a, D0 b, D1 c) {} }
  public static class H100_75 implements Handler { H100_75(D0 a, D1 b, D2 c) {} }
  public static class H100_76 implements Handler { H100_76(D1 a, D2 b, D3 c) {} }
  public static class H100_77 implements Handler { H100_77(D2 a, D3 b, D4 c) {} }
  public static class H100_78 implements Handler { H100_78(D3 a, D4 b, D0 c) {} }
  public static class H100_79 implements Handler { H100_79(D4 a, D0 b, D1 c) {} }
  public static class H100_80 implements Handler { H100_80(D0 a, D1 b, D2 c) {} }
  public static class H100_81 implements Handler { H100_81(D1 a, D2 b, D3 c) {} }
  public static class H100_82 implements Handler { H100_82(D2 a, D3 b, D4 c) {} }
  public static class H100_83 implements Handler { H100_83(D3 a, D4 b, D0 c) {} }
  public static class H100_84 implements Handler { H100_84(D4 a, D0 b, D1 c) {} }
  public static class H100_85 implements Handler { H100_85(D0 a, D1 b, D2 c) {} }
  public static class H100_86 implements Handler { H100_86(D1 a, D2 b, D3 c) {} }
  public static class H100_87 implements Handler { H100_87(D2 a, D3 b, D4 c) {} }
  public static class H100_88 implements Handler { H100_88(D3 a, D4 b, D0 c) {} }
  public static class H100_89 implements Handler { H100_89(D4 a, D0 b, D1 c) {} }
  public static class H100_90 implements Handler { H100_90(D0 a, D1 b, D2 c) {} }
  public static class H100_91 implements Handler { H100_91(D1 a, D2 b, D3 c) {} }
  public static class H100_92 implements Handler { H100_92(D2 a, D3 b, D4 c) {} }
  public static class H100_93 implements Handler { H100_93(D3 a, D4 b, D0 c) {} }
  public static class H100_94 implements Handler { H100_94(D4 a, D0 b, D1 c) {} }
  public static class H100_95 implements Handler { H100_95(D0 a, D1 b, D2 c) {} }
  public static class H100_96 implements Handler { H100_96(D1 a, D2 b, D3 c) {} }
  public static class H100_97 implements Handler { H100_97(D2 a, D3 b, D4 c) {} }
  public static class H100_98 implements Handler { H100_98(D3 a, D4 b, D0 c) {} }
  public static class H100_99 implements Handler { H100_99(D4 a, D0 b, D1 c) {} }

  @Module
  public static class Handlers100 {
    @Provides @IntoMap @StringKey("h0") static Handler h0(D0 a, D1 b, D2 c) { return new H100_0(a, b, c); }
    @Provides @IntoMap @StringKey("h1") static Handler h1(D1 a, D2 b, D3 c) { return new H100_1(a, b, c); }
    @Provides @IntoMap @StringKey("h2") static Handler h2(D2 a, D3 b, D4 c) { return new H100_2(a, b, c); }
    @Provides @IntoMap @StringKey("h3") static Handler h3(D3 a, D4 b, D0 c) { return new H100_3(a, b, c); }
    @Provides @IntoMap @StringKey("h4") static Handler h4(D4 a, D0 b, D1 c) { return new H100_4(a, b, c); }
    @Provides @IntoMap @StringKey("h5") static Handler h5(D0 a, D1 b, D2 c) { return new H100_5(a, b, c); }
    @Provides @IntoMap @StringKey("h6") static Handler h6(D1 a, D2 b, D3 c) { return new H100_6(a, b, c); }
    @Provides @IntoMap @StringKey("h7") static Handler h7(D2 a, D3 b, D4 c) { return new H100_7(a, b, c); }
    @Provides @IntoMap @StringKey("h8") static Handler h8(D3 a, D4 b, D0 c) { return new H100_8(a, b, c); }
    @Provides @IntoMap @StringKey("h9") static Handler h9(D4 a, D0 b, D1 c) { return new H100_9(a, b, c); }
    @Provides @IntoMap @StringKey("h10") static Handler h10(D0 a, D1 b, D2 c) { return new H100_10(a, b, c); }
    @Provides @IntoMap @StringKey("h11") static Handler h11(D1 a, D2 b, D3 c) { return new H100_11(a, b, c); }
    @Provides @IntoMap @StringKey("h12") static Handler h12(D2 a, D3 b, D4 c) { return new H100_12(a, b, c); }
    @Provides @IntoMap @StringKey("h13") static Handler h13(D3 a, D4 b, D0 c) { return new H100_13(a, b, c); }
    @Provides @IntoMap @StringKey("h14") static Handler h14(D4 a, D0 b, D1 c) { return new H100_14(a, b, c); }
    @Provides @IntoMap @StringKey("h15") static Handler h15(D0 a, D1 b, D2 c) { return new H100_15(a, b, c); }
    @Provides @IntoMap @StringKey("h16") static Handler h16(D1 a, D2 b, D3 c) { return new H100_16(a, b, c); }
    @Provides @IntoMap @StringKey("h17") static Handler h17(D2 a, D3 b, D4 c) { return new H100_17(a, b, c); }
    @Provides @IntoMap @StringKey("h18") static Handler h18(D3 a, D4 b, D0 c) { return new H100_18(a, b, c); }
    @Provides @IntoMap @StringKey("h19") static Handler h19(D4 a, D0 b, D1 c) { return new H100_19(a, b, c); }
    @Provides @IntoMap @StringKey("h20") static Handler h20(D0 a, D1 b, D2 c) { return new H100_20(a, b, c); }
    @Provides @IntoMap @StringKey("h21") static Handler h21(D1 a, D2 b, D3 c) { return new H100_21(a, b, c); }
    @Provides @IntoMap @StringKey("h22") static Handler h22(D2 a, D3 b, D4 c) { return new H100_22(a, b, c); }
    @Provides @IntoMap @StringKey("h23") static Handler h23(D3 a, D4 b, D0 c) { return new H100_23(a, b, c); }
    @Provides @IntoMap @StringKey("h24") static Handler h24(D4 a, D0 b, D1 c) { return new H100_24(a, b, c); }
    @Provides @IntoMap @StringKey("h25") static Handler h25(D0 a, D1 b, D2 c) { return new H100_25(a, b, c); }
    @Provides @IntoMap @StringKey("h26") static Handler h26(D1 a, D2 b, D3 c) { return new H100_26(a, b, c); }
    @Provides @IntoMap @StringKey("h27") static Handler h27(D2 a, D3 b, D4 c) { return new H100_27(a, b, c); }
    @Provides @IntoMap @StringKey("h28") static Handler h28(D3 a, D4 b, D0 c) { return new H100_28(a, b, c); }
    @Provides @IntoMap @StringKey("h29") static Handler h29(D4 a, D0 b, D1 c) { return new H100_29(a, b, c); }
    @Provides @IntoMap @StringKey("h30") static Handler h30(D0 a, D1 b, D2 c) { return new H100_30(a, b, c); }
    @Provides @IntoMap @StringKey("h31") static Handler h31(D1 a, D2 b, D3 c) { return new H100_31(a, b, c); }
    @Provides @IntoMap @StringKey("h32") static Handler h32(D2 a, D3 b, D4 c) { return new H100_32(a, b, c); }
    @Provides @IntoMap @StringKey("h33") static Handler h33(D3 a, D4 b, D0 c) { return new H100_33(a, b, c); }
    @Provides @IntoMap @StringKey("h34") static Handler h34(D4 a, D0 b, D1 c) { return new H100_34(a, b, c); }
    @Provides @IntoMap @StringKey("h35") static Handler h35(D0 a, D1 b, D2 c) { return new H100_35(a, b, c); }
    @Provides @IntoMap @StringKey("h36") static Handler h36(D1 a, D2 b, D3 c) { return new H100_36(a, b, c); }
    @Provides @IntoMap @StringKey("h37") static Handler h37(D2 a, D3 b, D4 c) { return new H100_37(a, b, c); }
    @Provides @IntoMap @StringKey("h38") static Handler h38(D3 a, D4 b, D0 c) { return new H100_38(a, b, c); }
    @Provides @IntoMap @StringKey("h39") static Handler h39(D4 a, D0 b, D1 c) { return new H100_39(a, b, c); }
    @Provides @IntoMap @StringKey("h40") static Handler h40(D0 a, D1 b, D2 c) { return new H100_40(a, b, c); }
    @Provides @IntoMap @StringKey("h41") static Handler h41(D1 a, D2 b, D3 c) { return new H100_41(a, b, c); }
    @Provides @IntoMap @StringKey("h42") static Handler h42(D2 a, D3 b, D4 c) { return new H100_42(a, b, c); }
    @Provides @IntoMap @StringKey("h43") static Handler h43(D3 a, D4 b, D0 c) { return new H100_43(a, b, c); }
    @Provides @IntoMap @StringKey("h44") static Handler h44(D4 a, D0 b, D1 c) { return new H100_44(a, b, c); }
    @Provides @IntoMap @StringKey("h45") static Handler h45(D0 a, D1 b, D2 c) { return new H100_45(a, b, c); }
    @Provides @IntoMap @StringKey("h46") static Handler h46(D1 a, D2 b, D3 c) { return new H100_46(a, b, c); }
    @Provides @IntoMap @StringKey("h47") static Handler h47(D2 a, D3 b, D4 c) { return new H100_47(a, b, c); }
    @Provides @IntoMap @StringKey("h48") static Handler h48(D3 a, D4 b, D0 c) { return new H100_48(a, b, c); }
    @Provides @IntoMap @StringKey("h49") static Handler h49(D4 a, D0 b, D1 c) { return new H100_49(a, b, c); }
    @Provides @IntoMap @StringKey("h50") static Handler h50(D0 a, D1 b, D2 c) { return new H100_50(a, b, c); }
    @Provides @IntoMap @StringKey("h51") static Handler h51(D1 a, D2 b, D3 c) { return new H100_51(a, b, c); }
    @Provides @IntoMap @StringKey("h52") static Handler h52(D2 a, D3 b, D4 c) { return new H100_52(a, b, c); }
    @Provides @IntoMap @StringKey("h53") static Handler h53(D3 a, D4 b, D0 c) { return new H100_53(a, b, c); }
    @Provides @IntoMap @StringKey("h54") static Handler h54(D4 a, D0 b, D1 c) { return new H100_54(a, b, c); }
    @Provides @IntoMap @StringKey("h55") static Handler h55(D0 a, D1 b, D2 c) { return new H100_55(a, b, c); }
    @Provides @IntoMap @StringKey("h56") static Handler h56(D1 a, D2 b, D3 c) { return new H100_56(a, b, c); }
    @Provides @IntoMap @StringKey("h57") static Handler h57(D2 a, D3 b, D4 c) { return new H100_57(a, b, c); }
    @Provides @IntoMap @StringKey("h58") static Handler h58(D3 a, D4 b, D0 c) { return new H100_58(a, b, c); }
    @Provides @IntoMap @StringKey("h59") static Handler h59(D4 a, D0 b, D1 c) { return new H100_59(a, b, c); }
    @Provides @IntoMap @StringKey("h60") static Handler h60(D0 a, D1 b, D2 c) { return new H100_60(a, b, c); }
    @Provides @IntoMap @StringKey("h61") static Handler h61(D1 a, D2 b, D3 c) { return new H100_61(a, b, c); }
    @Provides @IntoMap @StringKey("h62") static Handler h62(D2 a, D3 b, D4 c) { return new H100_62(a, b, c); }
    @Provides @IntoMap @StringKey("h63") static Handler h63(D3 a, D4 b, D0 c) { return new H100_63(a, b, c); }
    @Provides @IntoMap @StringKey("h64") static Handler h64(D4 a, D0 b, D1 c) { return new H100_64(a, b, c); }
    @Provides @IntoMap @StringKey("h65") static Handler h65(D0 a, D1 b, D2 c) { return new H100_65(a, b, c); }
    @Provides @IntoMap @StringKey("h66") static Handler h66(D1 a, D2 b, D3 c) { return new H100_66(a, b, c); }
    @Provides @IntoMap @StringKey("h67") static Handler h67(D2 a, D3 b, D4 c) { return new H100_67(a, b, c); }
    @Provides @IntoMap @StringKey("h68") static Handler h68(D3 a, D4 b, D0 c) { return new H100_68(a, b, c); }
    @Provides @IntoMap @StringKey("h69") static Handler h69(D4 a, D0 b, D1 c) { return new H100_69(a, b, c); }
    @Provides @IntoMap @StringKey("h70") static Handler h70(D0 a, D1 b, D2 c) { return new H100_70(a, b, c); }
    @Provides @IntoMap @StringKey("h71") static Handler h71(D1 a, D2 b, D3 c) { return new H100_71(a, b, c); }
    @Provides @IntoMap @StringKey("h72") static Handler h72(D2 a, D3 b, D4 c) { return new H100_72(a, b, c); }
    @Provides @IntoMap @StringKey("h73") static Handler h73(D3 a, D4 b, D0 c) { return new H100_73(a, b, c); }
    @Provides @IntoMap @StringKey("h74") static Handler h74(D4 a, D0 b, D1 c) { return new H100_74(a, b, c); }
    @Provides @IntoMap @StringKey("h75") static Handler h75(D0 a, D1 b, D2 c) { return new H100_75(a, b, c); }
    @Provides @IntoMap @StringKey("h76") static Handler h76(D1 a, D2 b, D3 c) { return new H100_76(a, b, c); }
    @Provides @IntoMap @StringKey("h77") static Handler h77(D2 a, D3 b, D4 c) { return new H100_77(a, b, c); }
    @Provides @IntoMap @StringKey("h78") static Handler h78(D3 a, D4 b, D0 c) { return new H100_78(a, b, c); }
    @Provides @IntoMap @StringKey("h79") static Handler h79(D4 a, D0 b, D1 c) { return new H100_79(a, b, c); }
    @Provides @IntoMap @StringKey("h80") static Handler h80(D0 a, D1 b, D2 c) { return new H100_80(a, b, c); }
    @Provides @IntoMap @StringKey("h81") static Handler h81(D1 a, D2 b, D3 c) { return new H100_81(a, b, c); }
    @Provides @IntoMap @StringKey("h82") static Handler h82(D2 a, D3 b, D4 c) { return new H100_82(a, b, c); }
    @Provides @IntoMap @StringKey("h83") static Handler h83(D3 a, D4 b, D0 c) { return new H100_83(a, b, c); }
    @Provides @IntoMap @StringKey("h84") static Handler h84(D4 a, D0 b, D1 c) { return new H100_84(a, b, c); }
    @Provides @IntoMap @StringKey("h85") static Handler h85(D0 a, D1 b, D2 c) { return new H100_85(a, b, c); }
    @Provides @IntoMap @StringKey("h86") static Handler h86(D1 a, D2 b, D3 c) { return new H100_86(a, b, c); }
    @Provides @IntoMap @StringKey("h87") static Handler h87(D2 a, D3 b, D4 c) { return new H100_87(a, b, c); }
    @Provides @IntoMap @StringKey("h88") static Handler h88(D3 a, D4 b, D0 c) { return new H100_88(a, b, c); }
    @Provides @IntoMap @StringKey("h89") static Handler h89(D4 a, D0 b, D1 c) { return new H100_89(a, b, c); }
    @Provides @IntoMap @StringKey("h90") static Handler h90(D0 a, D1 b, D2 c) { return new H100_90(a, b, c); }
    @Provides @IntoMap @StringKey("h91") static Handler h91(D1 a, D2 b, D3 c) { return new H100_91(a, b, c); }
    @Provides @IntoMap @StringKey("h92") static Handler h92(D2 a, D3 b, D4 c) { return new H100_92(a, b, c); }
    @Provides @IntoMap @StringKey("h93") static Handler h93(D3 a, D4 b, D0 c) { return new H100_93(a, b, c); }
    @Provides @IntoMap @StringKey("h94") static Handler h94(D4 a, D0 b, D1 c) { return new H100_94(a, b, c); }
    @Provides @IntoMap @StringKey("h95") static Handler h95(D0 a, D1 b, D2 c) { return new H100_95(a, b, c); }
    @Provides @IntoMap @StringKey("h96") static Handler h96(D1 a, D2 b, D3 c) { return new H100_96(a, b, c); }
    @Provides @IntoMap @StringKey("h97") static Handler h97(D2 a, D3 b, D4 c) { return new H100_97(a, b, c); }
    @Provides @IntoMap @StringKey("h98") static Handler h98(D3 a, D4 b, D0 c) { return new H100_98(a, b, c); }
    @Provides @IntoMap @StringKey("h99") static Handler h99(D4 a, D0 b, D1 c) { return new H100_99(a, b, c); }
  }

  @Component(dependencies = Deps.class, modules = Handlers100.class)
  public interface Graph100 {
    Map<String, Provider<Handler>> handlers();

    @Component.Factory
    interface Factory {
      Graph100 create(Deps deps);
    }
  }
}
