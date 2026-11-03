// ENABLE_SWITCHING_PROVIDERS: true

// Provider<Foo> from a @Provides function in a binding container, injected into another class.
@DependencyGraph(AppScope::class, bindingContainers = [FooBindings::class])
interface AppGraph {
  val consumer: Consumer
}

class Foo(val bar: Bar)

@Inject class Bar

@Inject class Consumer(val foo: Provider<Foo>, val bar: Bar)

@BindingContainer
object FooBindings {
  @Provides fun provideFoo(bar: Bar): Foo = Foo(bar)
}
