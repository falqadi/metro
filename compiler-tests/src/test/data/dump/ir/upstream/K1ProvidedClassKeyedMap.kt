// ENABLE_KCLASS_TO_CLASS_INTEROP
// ENABLE_DAGGER_INTEROP
// Fails today with a ClassCastException (Class cannot be cast to KClass): a plain @Provides Map<Class<*>, V> read through a Map<Class<*>, V> accessor.
import kotlin.reflect.KClass

class Foo

@BindingContainer
object Bindings {
  @Provides fun fooMap(): Map<Class<*>, Foo> = mapOf(Foo::class.java to Foo())
}

@DependencyGraph(AppScope::class, bindingContainers = [Bindings::class])
interface AppGraph {
  val fooMap: Map<Class<*>, Foo>
}
