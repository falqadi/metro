package repro;

public final class Main {
  public static void main(String[] args) {
    final int[] reads = {0};
    Fixtures.ParentDeps deps = () -> { reads[0]++; return new Fixtures.Service(); };
    Fixtures.ParentGraph parent = DaggerFixtures_ParentGraph.factory().create(deps);
    Fixtures.Consumer consumer = parent.childFactory().create().consumer();
    System.out.println("accessor reads after the child is built: " + reads[0]);
    consumer.service.get();
    consumer.service.get();
    System.out.println("accessor reads after two get() calls:    " + reads[0]);
  }
}
