// ENABLE_DAGGER_INTEROP
// ENABLE_SWITCHING_PROVIDERS: true
// Map<String, Provider<Handler>> where every entry takes 3 dependencies from an @Includes interface.
// Each read creates one provider per dependency per entry plus a factory per entry; Dagger (fastInit)
// builds those providers once. Prints bytes allocated per map read (ThreadMXBean, after warm-up).
@DependencyGraph(AppScope::class, bindingContainers = [HandlerBindings::class])
interface AppGraph {
  val handlers: Map<String, @JvmSuppressWildcards javax.inject.Provider<Handler>>

  @DependencyGraph.Factory
  interface Factory {
    fun create(@Includes deps: Deps): AppGraph
  }
}

interface Handler

class D0
class D1
class D2
class D3
class D4

interface Deps {
  val d0: D0
  val d1: D1
  val d2: D2
  val d3: D3
  val d4: D4
}

class H0(val a: D0, val b: D1, val c: D2) : Handler
class H1(val a: D1, val b: D2, val c: D3) : Handler
class H2(val a: D2, val b: D3, val c: D4) : Handler
class H3(val a: D3, val b: D4, val c: D0) : Handler
class H4(val a: D4, val b: D0, val c: D1) : Handler
class H5(val a: D0, val b: D1, val c: D2) : Handler
class H6(val a: D1, val b: D2, val c: D3) : Handler
class H7(val a: D2, val b: D3, val c: D4) : Handler
class H8(val a: D3, val b: D4, val c: D0) : Handler
class H9(val a: D4, val b: D0, val c: D1) : Handler
class H10(val a: D0, val b: D1, val c: D2) : Handler
class H11(val a: D1, val b: D2, val c: D3) : Handler
class H12(val a: D2, val b: D3, val c: D4) : Handler
class H13(val a: D3, val b: D4, val c: D0) : Handler
class H14(val a: D4, val b: D0, val c: D1) : Handler
class H15(val a: D0, val b: D1, val c: D2) : Handler
class H16(val a: D1, val b: D2, val c: D3) : Handler
class H17(val a: D2, val b: D3, val c: D4) : Handler
class H18(val a: D3, val b: D4, val c: D0) : Handler
class H19(val a: D4, val b: D0, val c: D1) : Handler
class H20(val a: D0, val b: D1, val c: D2) : Handler
class H21(val a: D1, val b: D2, val c: D3) : Handler
class H22(val a: D2, val b: D3, val c: D4) : Handler
class H23(val a: D3, val b: D4, val c: D0) : Handler
class H24(val a: D4, val b: D0, val c: D1) : Handler
class H25(val a: D0, val b: D1, val c: D2) : Handler
class H26(val a: D1, val b: D2, val c: D3) : Handler
class H27(val a: D2, val b: D3, val c: D4) : Handler
class H28(val a: D3, val b: D4, val c: D0) : Handler
class H29(val a: D4, val b: D0, val c: D1) : Handler
class H30(val a: D0, val b: D1, val c: D2) : Handler
class H31(val a: D1, val b: D2, val c: D3) : Handler
class H32(val a: D2, val b: D3, val c: D4) : Handler
class H33(val a: D3, val b: D4, val c: D0) : Handler
class H34(val a: D4, val b: D0, val c: D1) : Handler
class H35(val a: D0, val b: D1, val c: D2) : Handler
class H36(val a: D1, val b: D2, val c: D3) : Handler
class H37(val a: D2, val b: D3, val c: D4) : Handler
class H38(val a: D3, val b: D4, val c: D0) : Handler
class H39(val a: D4, val b: D0, val c: D1) : Handler
class H40(val a: D0, val b: D1, val c: D2) : Handler
class H41(val a: D1, val b: D2, val c: D3) : Handler
class H42(val a: D2, val b: D3, val c: D4) : Handler
class H43(val a: D3, val b: D4, val c: D0) : Handler
class H44(val a: D4, val b: D0, val c: D1) : Handler
class H45(val a: D0, val b: D1, val c: D2) : Handler
class H46(val a: D1, val b: D2, val c: D3) : Handler
class H47(val a: D2, val b: D3, val c: D4) : Handler
class H48(val a: D3, val b: D4, val c: D0) : Handler
class H49(val a: D4, val b: D0, val c: D1) : Handler
class H50(val a: D0, val b: D1, val c: D2) : Handler
class H51(val a: D1, val b: D2, val c: D3) : Handler
class H52(val a: D2, val b: D3, val c: D4) : Handler
class H53(val a: D3, val b: D4, val c: D0) : Handler
class H54(val a: D4, val b: D0, val c: D1) : Handler
class H55(val a: D0, val b: D1, val c: D2) : Handler
class H56(val a: D1, val b: D2, val c: D3) : Handler
class H57(val a: D2, val b: D3, val c: D4) : Handler
class H58(val a: D3, val b: D4, val c: D0) : Handler
class H59(val a: D4, val b: D0, val c: D1) : Handler
class H60(val a: D0, val b: D1, val c: D2) : Handler
class H61(val a: D1, val b: D2, val c: D3) : Handler
class H62(val a: D2, val b: D3, val c: D4) : Handler
class H63(val a: D3, val b: D4, val c: D0) : Handler
class H64(val a: D4, val b: D0, val c: D1) : Handler
class H65(val a: D0, val b: D1, val c: D2) : Handler
class H66(val a: D1, val b: D2, val c: D3) : Handler
class H67(val a: D2, val b: D3, val c: D4) : Handler
class H68(val a: D3, val b: D4, val c: D0) : Handler
class H69(val a: D4, val b: D0, val c: D1) : Handler
class H70(val a: D0, val b: D1, val c: D2) : Handler
class H71(val a: D1, val b: D2, val c: D3) : Handler
class H72(val a: D2, val b: D3, val c: D4) : Handler
class H73(val a: D3, val b: D4, val c: D0) : Handler
class H74(val a: D4, val b: D0, val c: D1) : Handler
class H75(val a: D0, val b: D1, val c: D2) : Handler
class H76(val a: D1, val b: D2, val c: D3) : Handler
class H77(val a: D2, val b: D3, val c: D4) : Handler
class H78(val a: D3, val b: D4, val c: D0) : Handler
class H79(val a: D4, val b: D0, val c: D1) : Handler
class H80(val a: D0, val b: D1, val c: D2) : Handler
class H81(val a: D1, val b: D2, val c: D3) : Handler
class H82(val a: D2, val b: D3, val c: D4) : Handler
class H83(val a: D3, val b: D4, val c: D0) : Handler
class H84(val a: D4, val b: D0, val c: D1) : Handler
class H85(val a: D0, val b: D1, val c: D2) : Handler
class H86(val a: D1, val b: D2, val c: D3) : Handler
class H87(val a: D2, val b: D3, val c: D4) : Handler
class H88(val a: D3, val b: D4, val c: D0) : Handler
class H89(val a: D4, val b: D0, val c: D1) : Handler
class H90(val a: D0, val b: D1, val c: D2) : Handler
class H91(val a: D1, val b: D2, val c: D3) : Handler
class H92(val a: D2, val b: D3, val c: D4) : Handler
class H93(val a: D3, val b: D4, val c: D0) : Handler
class H94(val a: D4, val b: D0, val c: D1) : Handler
class H95(val a: D0, val b: D1, val c: D2) : Handler
class H96(val a: D1, val b: D2, val c: D3) : Handler
class H97(val a: D2, val b: D3, val c: D4) : Handler
class H98(val a: D3, val b: D4, val c: D0) : Handler
class H99(val a: D4, val b: D0, val c: D1) : Handler

@BindingContainer
object HandlerBindings {
  @Provides @IntoMap @StringKey("h0") fun h0(a: D0, b: D1, c: D2): Handler = H0(a, b, c)
  @Provides @IntoMap @StringKey("h1") fun h1(a: D1, b: D2, c: D3): Handler = H1(a, b, c)
  @Provides @IntoMap @StringKey("h2") fun h2(a: D2, b: D3, c: D4): Handler = H2(a, b, c)
  @Provides @IntoMap @StringKey("h3") fun h3(a: D3, b: D4, c: D0): Handler = H3(a, b, c)
  @Provides @IntoMap @StringKey("h4") fun h4(a: D4, b: D0, c: D1): Handler = H4(a, b, c)
  @Provides @IntoMap @StringKey("h5") fun h5(a: D0, b: D1, c: D2): Handler = H5(a, b, c)
  @Provides @IntoMap @StringKey("h6") fun h6(a: D1, b: D2, c: D3): Handler = H6(a, b, c)
  @Provides @IntoMap @StringKey("h7") fun h7(a: D2, b: D3, c: D4): Handler = H7(a, b, c)
  @Provides @IntoMap @StringKey("h8") fun h8(a: D3, b: D4, c: D0): Handler = H8(a, b, c)
  @Provides @IntoMap @StringKey("h9") fun h9(a: D4, b: D0, c: D1): Handler = H9(a, b, c)
  @Provides @IntoMap @StringKey("h10") fun h10(a: D0, b: D1, c: D2): Handler = H10(a, b, c)
  @Provides @IntoMap @StringKey("h11") fun h11(a: D1, b: D2, c: D3): Handler = H11(a, b, c)
  @Provides @IntoMap @StringKey("h12") fun h12(a: D2, b: D3, c: D4): Handler = H12(a, b, c)
  @Provides @IntoMap @StringKey("h13") fun h13(a: D3, b: D4, c: D0): Handler = H13(a, b, c)
  @Provides @IntoMap @StringKey("h14") fun h14(a: D4, b: D0, c: D1): Handler = H14(a, b, c)
  @Provides @IntoMap @StringKey("h15") fun h15(a: D0, b: D1, c: D2): Handler = H15(a, b, c)
  @Provides @IntoMap @StringKey("h16") fun h16(a: D1, b: D2, c: D3): Handler = H16(a, b, c)
  @Provides @IntoMap @StringKey("h17") fun h17(a: D2, b: D3, c: D4): Handler = H17(a, b, c)
  @Provides @IntoMap @StringKey("h18") fun h18(a: D3, b: D4, c: D0): Handler = H18(a, b, c)
  @Provides @IntoMap @StringKey("h19") fun h19(a: D4, b: D0, c: D1): Handler = H19(a, b, c)
  @Provides @IntoMap @StringKey("h20") fun h20(a: D0, b: D1, c: D2): Handler = H20(a, b, c)
  @Provides @IntoMap @StringKey("h21") fun h21(a: D1, b: D2, c: D3): Handler = H21(a, b, c)
  @Provides @IntoMap @StringKey("h22") fun h22(a: D2, b: D3, c: D4): Handler = H22(a, b, c)
  @Provides @IntoMap @StringKey("h23") fun h23(a: D3, b: D4, c: D0): Handler = H23(a, b, c)
  @Provides @IntoMap @StringKey("h24") fun h24(a: D4, b: D0, c: D1): Handler = H24(a, b, c)
  @Provides @IntoMap @StringKey("h25") fun h25(a: D0, b: D1, c: D2): Handler = H25(a, b, c)
  @Provides @IntoMap @StringKey("h26") fun h26(a: D1, b: D2, c: D3): Handler = H26(a, b, c)
  @Provides @IntoMap @StringKey("h27") fun h27(a: D2, b: D3, c: D4): Handler = H27(a, b, c)
  @Provides @IntoMap @StringKey("h28") fun h28(a: D3, b: D4, c: D0): Handler = H28(a, b, c)
  @Provides @IntoMap @StringKey("h29") fun h29(a: D4, b: D0, c: D1): Handler = H29(a, b, c)
  @Provides @IntoMap @StringKey("h30") fun h30(a: D0, b: D1, c: D2): Handler = H30(a, b, c)
  @Provides @IntoMap @StringKey("h31") fun h31(a: D1, b: D2, c: D3): Handler = H31(a, b, c)
  @Provides @IntoMap @StringKey("h32") fun h32(a: D2, b: D3, c: D4): Handler = H32(a, b, c)
  @Provides @IntoMap @StringKey("h33") fun h33(a: D3, b: D4, c: D0): Handler = H33(a, b, c)
  @Provides @IntoMap @StringKey("h34") fun h34(a: D4, b: D0, c: D1): Handler = H34(a, b, c)
  @Provides @IntoMap @StringKey("h35") fun h35(a: D0, b: D1, c: D2): Handler = H35(a, b, c)
  @Provides @IntoMap @StringKey("h36") fun h36(a: D1, b: D2, c: D3): Handler = H36(a, b, c)
  @Provides @IntoMap @StringKey("h37") fun h37(a: D2, b: D3, c: D4): Handler = H37(a, b, c)
  @Provides @IntoMap @StringKey("h38") fun h38(a: D3, b: D4, c: D0): Handler = H38(a, b, c)
  @Provides @IntoMap @StringKey("h39") fun h39(a: D4, b: D0, c: D1): Handler = H39(a, b, c)
  @Provides @IntoMap @StringKey("h40") fun h40(a: D0, b: D1, c: D2): Handler = H40(a, b, c)
  @Provides @IntoMap @StringKey("h41") fun h41(a: D1, b: D2, c: D3): Handler = H41(a, b, c)
  @Provides @IntoMap @StringKey("h42") fun h42(a: D2, b: D3, c: D4): Handler = H42(a, b, c)
  @Provides @IntoMap @StringKey("h43") fun h43(a: D3, b: D4, c: D0): Handler = H43(a, b, c)
  @Provides @IntoMap @StringKey("h44") fun h44(a: D4, b: D0, c: D1): Handler = H44(a, b, c)
  @Provides @IntoMap @StringKey("h45") fun h45(a: D0, b: D1, c: D2): Handler = H45(a, b, c)
  @Provides @IntoMap @StringKey("h46") fun h46(a: D1, b: D2, c: D3): Handler = H46(a, b, c)
  @Provides @IntoMap @StringKey("h47") fun h47(a: D2, b: D3, c: D4): Handler = H47(a, b, c)
  @Provides @IntoMap @StringKey("h48") fun h48(a: D3, b: D4, c: D0): Handler = H48(a, b, c)
  @Provides @IntoMap @StringKey("h49") fun h49(a: D4, b: D0, c: D1): Handler = H49(a, b, c)
  @Provides @IntoMap @StringKey("h50") fun h50(a: D0, b: D1, c: D2): Handler = H50(a, b, c)
  @Provides @IntoMap @StringKey("h51") fun h51(a: D1, b: D2, c: D3): Handler = H51(a, b, c)
  @Provides @IntoMap @StringKey("h52") fun h52(a: D2, b: D3, c: D4): Handler = H52(a, b, c)
  @Provides @IntoMap @StringKey("h53") fun h53(a: D3, b: D4, c: D0): Handler = H53(a, b, c)
  @Provides @IntoMap @StringKey("h54") fun h54(a: D4, b: D0, c: D1): Handler = H54(a, b, c)
  @Provides @IntoMap @StringKey("h55") fun h55(a: D0, b: D1, c: D2): Handler = H55(a, b, c)
  @Provides @IntoMap @StringKey("h56") fun h56(a: D1, b: D2, c: D3): Handler = H56(a, b, c)
  @Provides @IntoMap @StringKey("h57") fun h57(a: D2, b: D3, c: D4): Handler = H57(a, b, c)
  @Provides @IntoMap @StringKey("h58") fun h58(a: D3, b: D4, c: D0): Handler = H58(a, b, c)
  @Provides @IntoMap @StringKey("h59") fun h59(a: D4, b: D0, c: D1): Handler = H59(a, b, c)
  @Provides @IntoMap @StringKey("h60") fun h60(a: D0, b: D1, c: D2): Handler = H60(a, b, c)
  @Provides @IntoMap @StringKey("h61") fun h61(a: D1, b: D2, c: D3): Handler = H61(a, b, c)
  @Provides @IntoMap @StringKey("h62") fun h62(a: D2, b: D3, c: D4): Handler = H62(a, b, c)
  @Provides @IntoMap @StringKey("h63") fun h63(a: D3, b: D4, c: D0): Handler = H63(a, b, c)
  @Provides @IntoMap @StringKey("h64") fun h64(a: D4, b: D0, c: D1): Handler = H64(a, b, c)
  @Provides @IntoMap @StringKey("h65") fun h65(a: D0, b: D1, c: D2): Handler = H65(a, b, c)
  @Provides @IntoMap @StringKey("h66") fun h66(a: D1, b: D2, c: D3): Handler = H66(a, b, c)
  @Provides @IntoMap @StringKey("h67") fun h67(a: D2, b: D3, c: D4): Handler = H67(a, b, c)
  @Provides @IntoMap @StringKey("h68") fun h68(a: D3, b: D4, c: D0): Handler = H68(a, b, c)
  @Provides @IntoMap @StringKey("h69") fun h69(a: D4, b: D0, c: D1): Handler = H69(a, b, c)
  @Provides @IntoMap @StringKey("h70") fun h70(a: D0, b: D1, c: D2): Handler = H70(a, b, c)
  @Provides @IntoMap @StringKey("h71") fun h71(a: D1, b: D2, c: D3): Handler = H71(a, b, c)
  @Provides @IntoMap @StringKey("h72") fun h72(a: D2, b: D3, c: D4): Handler = H72(a, b, c)
  @Provides @IntoMap @StringKey("h73") fun h73(a: D3, b: D4, c: D0): Handler = H73(a, b, c)
  @Provides @IntoMap @StringKey("h74") fun h74(a: D4, b: D0, c: D1): Handler = H74(a, b, c)
  @Provides @IntoMap @StringKey("h75") fun h75(a: D0, b: D1, c: D2): Handler = H75(a, b, c)
  @Provides @IntoMap @StringKey("h76") fun h76(a: D1, b: D2, c: D3): Handler = H76(a, b, c)
  @Provides @IntoMap @StringKey("h77") fun h77(a: D2, b: D3, c: D4): Handler = H77(a, b, c)
  @Provides @IntoMap @StringKey("h78") fun h78(a: D3, b: D4, c: D0): Handler = H78(a, b, c)
  @Provides @IntoMap @StringKey("h79") fun h79(a: D4, b: D0, c: D1): Handler = H79(a, b, c)
  @Provides @IntoMap @StringKey("h80") fun h80(a: D0, b: D1, c: D2): Handler = H80(a, b, c)
  @Provides @IntoMap @StringKey("h81") fun h81(a: D1, b: D2, c: D3): Handler = H81(a, b, c)
  @Provides @IntoMap @StringKey("h82") fun h82(a: D2, b: D3, c: D4): Handler = H82(a, b, c)
  @Provides @IntoMap @StringKey("h83") fun h83(a: D3, b: D4, c: D0): Handler = H83(a, b, c)
  @Provides @IntoMap @StringKey("h84") fun h84(a: D4, b: D0, c: D1): Handler = H84(a, b, c)
  @Provides @IntoMap @StringKey("h85") fun h85(a: D0, b: D1, c: D2): Handler = H85(a, b, c)
  @Provides @IntoMap @StringKey("h86") fun h86(a: D1, b: D2, c: D3): Handler = H86(a, b, c)
  @Provides @IntoMap @StringKey("h87") fun h87(a: D2, b: D3, c: D4): Handler = H87(a, b, c)
  @Provides @IntoMap @StringKey("h88") fun h88(a: D3, b: D4, c: D0): Handler = H88(a, b, c)
  @Provides @IntoMap @StringKey("h89") fun h89(a: D4, b: D0, c: D1): Handler = H89(a, b, c)
  @Provides @IntoMap @StringKey("h90") fun h90(a: D0, b: D1, c: D2): Handler = H90(a, b, c)
  @Provides @IntoMap @StringKey("h91") fun h91(a: D1, b: D2, c: D3): Handler = H91(a, b, c)
  @Provides @IntoMap @StringKey("h92") fun h92(a: D2, b: D3, c: D4): Handler = H92(a, b, c)
  @Provides @IntoMap @StringKey("h93") fun h93(a: D3, b: D4, c: D0): Handler = H93(a, b, c)
  @Provides @IntoMap @StringKey("h94") fun h94(a: D4, b: D0, c: D1): Handler = H94(a, b, c)
  @Provides @IntoMap @StringKey("h95") fun h95(a: D0, b: D1, c: D2): Handler = H95(a, b, c)
  @Provides @IntoMap @StringKey("h96") fun h96(a: D1, b: D2, c: D3): Handler = H96(a, b, c)
  @Provides @IntoMap @StringKey("h97") fun h97(a: D2, b: D3, c: D4): Handler = H97(a, b, c)
  @Provides @IntoMap @StringKey("h98") fun h98(a: D3, b: D4, c: D0): Handler = H98(a, b, c)
  @Provides @IntoMap @StringKey("h99") fun h99(a: D4, b: D0, c: D1): Handler = H99(a, b, c)
}

private val tmx = java.lang.management.ManagementFactory.getThreadMXBean() as com.sun.management.ThreadMXBean

private fun alloc(label: String, block: () -> Any?) {
  var sink: Any? = null
  repeat(20000) { sink = block() }
  for (round in 1..3) {
  val id = Thread.currentThread().threadId()
  val before = tmx.getThreadAllocatedBytes(id)
  repeat(10000) { sink = block() }
  val after = tmx.getThreadAllocatedBytes(id)
  println("$label round $round: " + ((after - before) / 10000.0) + " bytes allocated per map read")
  }
  if (sink == null) println("null")
}

fun box(): String {
  val g = createGraphFactory<AppGraph.Factory>().create(object : Deps {
    override val d0 = D0()
    override val d1 = D1()
    override val d2 = D2()
    override val d3 = D3()
    override val d4 = D4()
  })
  alloc("javax Provider, 100 entries") { g.handlers }
  return "OK"
}
