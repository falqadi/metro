// ENABLE_SWITCHING_PROVIDERS: true

// A constructor-injected class that takes Provider<Foo> and a scoped sibling forces the graph to
// materialize a Provider<Foo> for Foo.
@DependencyGraph(AppScope::class)
interface AppGraph {
  val consumer: Consumer
}

@Inject class Bar

@Inject class Foo(val bar: Bar)

@Inject class Consumer(val foo: Provider<Foo>, val bar: Bar)
