// ENABLE_DAGGER_INTEROP
// ENABLE_KCLASS_TO_CLASS_INTEROP
// ENABLE_SWITCHING_PROVIDERS: true

// Same shape with javax Provider values and java.lang.Class keys, as Dagger-style consumers declare it.
@DependencyGraph(AppScope::class, bindingContainers = [HandlerBindings::class])
interface AppGraph {
  val handlers: Map<Class<*>, @JvmSuppressWildcards javax.inject.Provider<Handler>>
}

interface Handler

@Inject class Dep

@Inject class AlphaHandler(val dep: Dep) : Handler

@Inject class BetaHandler(val dep: Dep) : Handler

@BindingContainer
object HandlerBindings {
  @Provides @IntoMap @ClassKey(AlphaHandler::class)
  fun alpha(handler: AlphaHandler): Handler = handler

  @Provides @IntoMap @ClassKey(BetaHandler::class)
  fun beta(handler: BetaHandler): Handler = handler
}
