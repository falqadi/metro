package repro;

public final class Main {

  private static final com.sun.management.ThreadMXBean TMX =
      (com.sun.management.ThreadMXBean) java.lang.management.ManagementFactory.getThreadMXBean();
  private static Object sink;

  static void alloc(String label, java.util.function.Supplier<Object> call) {
    for (int i = 0; i < 20000; i++) sink = call.get();
    long id = Thread.currentThread().getId();
    for (int round = 1; round <= 3; round++) {
      long before = TMX.getThreadAllocatedBytes(id);
      for (int i = 0; i < 10000; i++) sink = call.get();
      long after = TMX.getThreadAllocatedBytes(id);
      System.out.println(label + " round " + round + ": " + ((after - before) / 10000.0) + " bytes allocated per call");
    }
  }

  public static void main(String[] args) {
    Fixtures.Deps deps = new Fixtures.Deps() {
      public Fixtures.D0 d0() { return new Fixtures.D0(); }
      public Fixtures.D1 d1() { return new Fixtures.D1(); }
      public Fixtures.D2 d2() { return new Fixtures.D2(); }
      public Fixtures.D3 d3() { return new Fixtures.D3(); }
      public Fixtures.D4 d4() { return new Fixtures.D4(); }
    };
    Fixtures.AppGraph graph = DaggerFixtures_AppGraph.factory().create(deps);
    System.out.println("map entries: " + graph.handlers().size());
    alloc("Map<String, Provider<Handler>> read, 20 entries", graph::handlers);
  }
}
