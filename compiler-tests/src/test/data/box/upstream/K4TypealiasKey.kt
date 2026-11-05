// IGNORE_BACKEND: JS_IR
// ENABLE_KCLASS_TO_CLASS_INTEROP
// ENABLE_DAGGER_INTEROP
// Fails today with a ClassCastException: K1 with the key type behind a typealias.
import kotlin.reflect.KClass

class Foo

typealias PluginKey = Class<*>

@BindingContainer
object Bindings {
  @Provides fun fooMap(): Map<PluginKey, Foo> = mapOf(Foo::class.java to Foo())
}

@DependencyGraph(AppScope::class, bindingContainers = [Bindings::class])
interface AppGraph {
  val fooMap: Map<PluginKey, Foo>
}

fun box(): String {
  check(createGraph<AppGraph>().fooMap.containsKey(Foo::class.java))
  return "OK"
}
