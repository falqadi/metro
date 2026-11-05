package repro;

import dagger.Component;
import dagger.Subcomponent;
import javax.inject.Inject;
import javax.inject.Provider;

public final class Fixtures {
  private Fixtures() {}

  public static class Service {}

  public interface ParentDeps {
    Service service();
  }

  public static class Consumer {
    final Provider<Service> service;

    @Inject
    public Consumer(Provider<Service> service) {
      this.service = service;
    }
  }

  @Subcomponent
  public interface ChildGraph {
    Consumer consumer();

    @Subcomponent.Factory
    interface Factory {
      ChildGraph create();
    }
  }

  @Component(dependencies = ParentDeps.class)
  public interface ParentGraph {
    ChildGraph.Factory childFactory();

    @Component.Factory
    interface Factory {
      ParentGraph create(ParentDeps deps);
    }
  }
}
