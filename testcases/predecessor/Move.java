package predecessor;

public class Move {
  public static void onMoved(int x, int y) {
    System.out.println("It is moved.");
    System.out.println("$caller = " + $caller);
    System.out.println("$predecessor = " + $predecessor);
    ((Shape)$predecessor).moved();
  }
  public static void onMoving(int x, int y) {
    System.out.println("It starts moving.");
    System.out.println("$caller = " + $caller);
    System.out.println("$predecessor = " + $predecessor);
    ((Shape)$predecessor).moving();
  }
}

