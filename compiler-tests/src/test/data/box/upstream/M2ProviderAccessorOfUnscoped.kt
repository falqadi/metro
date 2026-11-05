// Control, passes: a Provider<Foo> accessor keeps the @SingleIn Registry.
class Registry

class Foo(val registry: Registry)

@BindingContainer
object Bindings {
  @SingleIn(AppScope::class) @Provides fun registry(): Registry = Registry()
  @Provides fun foo(registry: Registry): Foo = Foo(registry)
}

@DependencyGraph(AppScope::class, bindingContainers = [Bindings::class])
interface AppGraph {
  val foo: Provider<Foo>
}

fun box(): String {
  val g = createGraph<AppGraph>()
  val a = g.foo().registry
  val b = g.foo().registry
  check(a === b) { "Expected one @SingleIn Registry per graph, got two instances" }
  return "OK"
}
