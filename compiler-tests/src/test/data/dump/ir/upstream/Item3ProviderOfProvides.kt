// ENABLE_SWITCHING_PROVIDERS: true

// Same as item 2, but Foo comes from a @Provides function in a binding container.
@DependencyGraph(AppScope::class, bindingContainers = [FooBindings::class])
interface AppGraph {
  val foo: Foo
  val fooProvider: Provider<Foo>
}

class Foo(val bar: Bar)

@Inject class Bar

@BindingContainer
object FooBindings {
  @Provides fun provideFoo(bar: Bar): Foo = Foo(bar)
}
