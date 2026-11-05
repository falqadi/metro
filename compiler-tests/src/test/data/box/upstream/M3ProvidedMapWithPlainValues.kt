// Control, passes: the same provided map with plain values, Map<K, V>, keeps the @SingleIn Registry.
class Registry

class Foo(val registry: Registry)

@BindingContainer
object Bindings {
  @SingleIn(AppScope::class) @Provides fun registry(): Registry = Registry()
  @Provides fun fooMap(registry: Registry): Map<String, Foo> = mapOf("a" to Foo(registry))
}

@DependencyGraph(AppScope::class, bindingContainers = [Bindings::class])
interface AppGraph {
  val fooMap: Map<String, Foo>
}

fun box(): String {
  val g = createGraph<AppGraph>()
  val a = g.fooMap.getValue("a").registry
  val b = g.fooMap.getValue("a").registry
  check(a === b) { "Expected one @SingleIn Registry per graph, got two instances" }
  return "OK"
}
