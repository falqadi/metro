package repro;

public final class Main {
  public static void main(String[] args) {
    Fixtures.AppGraph graph = DaggerFixtures_AppGraph.create();
    Fixtures.Registry first = graph.fooMap().get("a").get().registry;
    Fixtures.Registry second = graph.fooMap().get("a").get().registry;
    boolean same = first == second;
    System.out.println("two reads of the map share one @Singleton Registry: " + same);
    if (!same) System.exit(1);
  }
}
