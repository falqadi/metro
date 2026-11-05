// IGNORE_BACKEND: JS_IR
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
