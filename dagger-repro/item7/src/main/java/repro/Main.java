package repro;

public final class Main {
  public static void main(String[] args) {
    Fixtures.AppGraph graph = DaggerFixtures_AppGraph.create();
    System.out.println("accessor map contains Foo.class: " + graph.fooMap().containsKey(Fixtures.Foo.class));
    System.out.println("injected map contains Foo.class: " + graph.holder().map.containsKey(Fixtures.Foo.class));
  }
}
