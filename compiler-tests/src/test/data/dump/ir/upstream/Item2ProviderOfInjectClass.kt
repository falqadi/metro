// ENABLE_SWITCHING_PROVIDERS: true

// A Provider<Foo> accessor for a constructor-injected class. Compare to the value accessor `foo`,
// which constructs Foo directly.
@DependencyGraph(AppScope::class)
interface AppGraph {
  val foo: Foo
  val fooProvider: Provider<Foo>
}

@Inject class Bar

@Inject class Foo(val bar: Bar)
