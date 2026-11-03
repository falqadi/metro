// ENABLE_DAGGER_INTEROP
// ENABLE_SWITCHING_PROVIDERS: true

// A javax.inject.Provider<Foo> accessor, as Dagger-style consumers declare it.
@DependencyGraph(AppScope::class)
interface AppGraph {
  val fooProvider: javax.inject.Provider<Foo>
}

@Inject class Bar

@Inject class Foo(val bar: Bar)

@Inject class Plain
