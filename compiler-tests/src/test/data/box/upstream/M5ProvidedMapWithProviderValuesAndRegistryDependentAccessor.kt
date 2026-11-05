// Control, passes: M1 plus a Foo accessor that needs Registry, which makes Metro create the scoped field.
class Registry

class Foo(val registry: Registry)

@BindingContainer
object Bindings {
  @SingleIn(AppScope::class) @Provides fun registry(): Registry = Registry()
  @Provides fun fooMap(registry: Registry): Map<String, Provider<Foo>> = mapOf("a" to Provider { Foo(registry) })
  @Provides fun foo(registry: Registry): Foo = Foo(registry)
}

@DependencyGraph(AppScope::class, bindingContainers = [Bindings::class])
interface AppGraph {
  val fooMap: Map<String, Provider<Foo>>
  val foo: Foo
}

fun box(): String {
  val g = createGraph<AppGraph>()
  val a = g.fooMap.getValue("a")().registry
  val b = g.fooMap.getValue("a")().registry
  check(a === b) { "Expected one @SingleIn Registry per graph, got two instances" }
  return "OK"
}
