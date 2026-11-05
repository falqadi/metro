// IGNORE_BACKEND: JS_IR
// Expected to pass. Fails today: M1 plus an unrelated Set<String> accessor, which does not need Registry.
class Registry

class Foo(val registry: Registry)

@BindingContainer
object Bindings {
  @SingleIn(AppScope::class) @Provides fun registry(): Registry = Registry()
  @Provides fun fooMap(registry: Registry): Map<String, Provider<Foo>> = mapOf("a" to Provider { Foo(registry) })
  @Provides @IntoSet fun item(): String = "x"
}

@DependencyGraph(AppScope::class, bindingContainers = [Bindings::class])
interface AppGraph {
  val fooMap: Map<String, Provider<Foo>>
  val items: Set<String>
}

fun box(): String {
  val g = createGraph<AppGraph>()
  val a = g.fooMap.getValue("a")().registry
  val b = g.fooMap.getValue("a")().registry
  check(a === b) { "Expected one @SingleIn Registry per graph, got two instances" }
  return "OK"
}
