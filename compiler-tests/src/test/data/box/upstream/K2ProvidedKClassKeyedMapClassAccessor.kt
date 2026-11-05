// IGNORE_BACKEND: JS_IR
// ENABLE_KCLASS_TO_CLASS_INTEROP
// ENABLE_DAGGER_INTEROP
// Control, passes: the provided map has KClass keys.
import kotlin.reflect.KClass

class Foo

@BindingContainer
object Bindings {
  @Provides fun fooMap(): Map<KClass<*>, Foo> = mapOf(Foo::class to Foo())
}

@DependencyGraph(AppScope::class, bindingContainers = [Bindings::class])
interface AppGraph {
  val fooMap: Map<Class<*>, Foo>
}

fun box(): String {
  check(createGraph<AppGraph>().fooMap.containsKey(Foo::class.java))
  return "OK"
}
