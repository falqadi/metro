// ENABLE_SWITCHING_PROVIDERS: true

// Map<K, Provider<V>> accessor. The map is built on every call of the accessor.
@DependencyGraph(AppScope::class)
interface AppGraph {
  val handlers: Map<String, Provider<Handler>>
}

interface Handler

@Inject class AlphaHandler(val dep: Dep) : Handler

@Inject class BetaHandler(val dep: Dep) : Handler

@Inject class Dep

@ContributesIntoMap(AppScope::class)
@StringKey("alpha")
@Inject
class AlphaContribution(val dep: Dep) : Handler

@ContributesIntoMap(AppScope::class)
@StringKey("beta")
@Inject
class BetaContribution(val dep: Dep) : Handler
