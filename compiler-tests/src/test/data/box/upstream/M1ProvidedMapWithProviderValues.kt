// IGNORE_BACKEND: JS_IR
// Expected to pass. Fails today: a @SingleIn binding used only by a plain @Provides that returns
// Map<K, Provider<V>> is inlined, so each read of the map creates a new Registry.
class Registry

class Foo(val registry: Registry)

@BindingContainer
object Bindings {
  @SingleIn(AppScope::class) @Provides fun registry(): Registry = Registry()
  @Provides fun fooMap(registry: Registry): Map<String, Provider<Foo>> = mapOf("a" to Provider { Foo(registry) })
}

@DependencyGraph(AppScope::class, bindingContainers = [Bindings::class])
interface AppGraph {
  val fooMap: Map<String, Provider<Foo>>
}

fun box(): String {
  val g = createGraph<AppGraph>()
  val a = g.fooMap.getValue("a")().registry
  val b = g.fooMap.getValue("a")().registry
  check(a === b) { "Expected one @SingleIn Registry per graph, got two instances" }
  return "OK"
}
