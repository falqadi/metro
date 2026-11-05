// Provider<T> of a parent graph-dependency accessor, requested inside a graph extension,
// should call the accessor when the provider is read, not while the extension is built.

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

fun box(): String {
  val deps = CountingDeps()
  val parent = createGraphFactory<ParentGraph.Factory>().create(deps)
  val consumer = parent.create().consumer
  val readsAfterBuild = deps.reads
  consumer.service()
  consumer.service()
  val readsAfterTwoReads = deps.reads
  if (readsAfterBuild != 0 || readsAfterTwoReads != 2) {
    return "FAIL: accessor reads after building the child = $readsAfterBuild (expected 0), after two provider reads = $readsAfterTwoReads (expected 2)"
  }
  return "OK"
}
