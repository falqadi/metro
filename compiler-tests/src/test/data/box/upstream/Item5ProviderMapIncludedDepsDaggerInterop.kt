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
  alloc("DaggerInterop") { g.handlers }
  return "OK"
}
