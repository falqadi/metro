// ENABLE_DAGGER_INTEROP
// CHARACTERIZATION (expected to FAIL on upstream main): a dagger.Lazy accessor builds a new
// DaggerInteropDoubleCheck on every call. Both the scoped and the unscoped provider are stable
// fields, so the Lazy wrapper could be read from a field. Dagger 2.60.1 builds DoubleCheck.lazy
// inside each accessor call, so this may match Dagger rather than be a Metro-only defect.

var fooConstructions = 0

@SingleIn(AppScope::class)
@Inject class ScopedFoo {
  init {
    fooConstructions++
  }
}

@Inject class UnscopedFoo

@DependencyGraph(AppScope::class)
interface AppGraph {
  val scopedLazy: dagger.Lazy<ScopedFoo>
  val unscopedLazy: dagger.Lazy<UnscopedFoo>
}

fun box(): String {
  val graph = createGraph<AppGraph>()
  assertSame(graph.scopedLazy, graph.scopedLazy)
  assertSame(graph.unscopedLazy, graph.unscopedLazy)
  assertSame(graph.scopedLazy.get(), graph.scopedLazy.get())
  assertEquals(1, fooConstructions)
  return "OK"
}
