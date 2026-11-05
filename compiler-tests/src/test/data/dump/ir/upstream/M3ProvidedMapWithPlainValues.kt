// IGNORE_BACKEND: JS_IR
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
