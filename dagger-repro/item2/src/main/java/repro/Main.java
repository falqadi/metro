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
    Fixtures.Item2Graph g2 = DaggerFixtures_Item2Graph.create();
    Fixtures.Item3Graph g3 = DaggerFixtures_Item3Graph.create();
    alloc("accessor foo()                         ", g2::foo);
    alloc("accessor Provider<Foo> fooProvider()   ", g2::fooProvider);
    alloc("accessor consumer() takes Provider<Foo>", g2::consumer);
    alloc("accessor consumer(), Foo from @Provides", g3::consumer);
  }
}
