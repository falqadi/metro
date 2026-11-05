package repro;

public final class Main {

  private static final com.sun.management.ThreadMXBean TMX =
      (com.sun.management.ThreadMXBean) java.lang.management.ManagementFactory.getThreadMXBean();
  private static Object sink;

  static void alloc(String label, java.util.function.Supplier<Object> call, int round) {
    for (int i = 0; i < 20000; i++) sink = call.get();
    long id = Thread.currentThread().getId();
    long before = TMX.getThreadAllocatedBytes(id);
    for (int i = 0; i < 10000; i++) sink = call.get();
    long after = TMX.getThreadAllocatedBytes(id);
    System.out.println(label + " round " + round + ": " + ((after - before) / 10000.0) + " bytes allocated per map read");
  }

  public static void main(String[] args) {
    Fixtures.TwoEntryGraph two = DaggerFixtures_TwoEntryGraph.create();
    System.out.println("two-entry graph keys: " + new java.util.TreeSet<>(two.handlers().keySet()));
    Fixtures.Deps deps = new Fixtures.Deps() {
      public Fixtures.D0 d0() { return new Fixtures.D0(); }
      public Fixtures.D1 d1() { return new Fixtures.D1(); }
      public Fixtures.D2 d2() { return new Fixtures.D2(); }
      public Fixtures.D3 d3() { return new Fixtures.D3(); }
      public Fixtures.D4 d4() { return new Fixtures.D4(); }
    };
    Fixtures.Graph20 graph20 = DaggerFixtures_Graph20.factory().create(deps);
    Fixtures.Graph100 graph100 = DaggerFixtures_Graph100.factory().create(deps);
    for (int round = 1; round <= 3; round++) {
      alloc("Dagger, 20 entries ", graph20::handlers, round);
      alloc("Dagger, 100 entries", graph100::handlers, round);
    }
  }
}
