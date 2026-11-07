// ENABLE_DAGGER_INTEROP
// CHARACTERIZATION (expected to FAIL on upstream main): the dagger.Lazy accessor for a scoped
// binding allocates a new DaggerInteropDoubleCheck on every call. The scoped provider is stable,
// so the dagger.Lazy handle could be cached in a field. The Metro Lazy accessor is not included
// here because it already returns the cached scoped provider field.

@SingleIn(AppScope::class)
@Inject class ScopedFoo

@DependencyGraph(AppScope::class)
interface AppGraph {
  val fooDaggerLazy: dagger.Lazy<ScopedFoo>
}

fun box(): String {
  val graph = createGraph<AppGraph>()
  assertSame(graph.fooDaggerLazy, graph.fooDaggerLazy)
  return "OK"
}
