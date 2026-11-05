// IGNORE_BACKEND: JS_IR
// ENABLE_KCLASS_TO_CLASS_INTEROP
// ENABLE_DAGGER_INTEROP
// Fails today with a ClassCastException: K1 where the accessor is inherited from an interface in another module.

// MODULE: lib
class Foo

interface HostApi {
  val fooMap: Map<Class<*>, Foo>
}

// MODULE: main(lib)
@BindingContainer
object Bindings {
  @Provides fun fooMap(): Map<Class<*>, Foo> = mapOf(Foo::class.java to Foo())
}

@DependencyGraph(AppScope::class, bindingContainers = [Bindings::class])
interface AppGraph : HostApi

fun box(): String {
  check(createGraph<AppGraph>().fooMap.containsKey(Foo::class.java))
  return "OK"
}
