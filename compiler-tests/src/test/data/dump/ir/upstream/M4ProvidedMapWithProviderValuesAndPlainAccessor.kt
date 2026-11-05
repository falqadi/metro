// IGNORE_BACKEND: JS_IR
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
