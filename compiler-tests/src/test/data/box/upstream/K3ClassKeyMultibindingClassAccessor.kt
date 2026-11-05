// IGNORE_BACKEND: JS_IR
// ENABLE_KCLASS_TO_CLASS_INTEROP
// ENABLE_DAGGER_INTEROP
// Control, passes: an @IntoMap @ClassKey multibinding.
class Foo

@BindingContainer
object Bindings {
  @Provides @IntoMap @ClassKey(Foo::class) fun foo(): Foo = Foo()
}

@DependencyGraph(AppScope::class, bindingContainers = [Bindings::class])
interface AppGraph {
  val fooMap: Map<Class<*>, Foo>
}

fun box(): String {
  check(createGraph<AppGraph>().fooMap.containsKey(Foo::class.java))
  return "OK"
}
