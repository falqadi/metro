// ENABLE_SWITCHING_PROVIDERS: true
// Same shape as the box test of the same name: dump of the extension's consumer accessor.

class Service

class CountingDeps : ParentDeps {
  var reads = 0
    private set

  override val service: Service
    get() {
      reads++
      return Service()
    }
}

interface ParentDeps {
  val service: Service
}

@DependencyGraph(scope = AppScope::class)
interface ParentGraph {
  @DependencyGraph.Factory
  interface Factory {
    fun create(@Includes deps: ParentDeps): ParentGraph
  }
}

@Inject class Consumer(val service: Provider<Service>)

@GraphExtension(scope = Unit::class)
interface ChildGraph {
  val consumer: Consumer

  @GraphExtension.Factory
  @ContributesTo(scope = AppScope::class)
  interface Factory {
    fun create(): ChildGraph
  }
}
