// IGNORE_BACKEND: JS_IR
// ENABLE_KCLASS_TO_CLASS_INTEROP
// ENABLE_DAGGER_INTEROP
// Fails today with a ClassCastException: K1 with the map injected into another binding.
import kotlin.reflect.KClass

class Foo

class Holder(val map: Map<Class<*>, Foo>)

@BindingContainer
object Bindings {
  @Provides fun fooMap(): Map<Class<*>, Foo> = mapOf(Foo::class.java to Foo())
  @Provides fun holder(map: Map<Class<*>, Foo>): Holder = Holder(map)
}

@DependencyGraph(AppScope::class, bindingContainers = [Bindings::class])
interface AppGraph {
  val holder: Holder
}

fun box(): String {
  check(createGraph<AppGraph>().holder.map.containsKey(Foo::class.java))
  return "OK"
}
