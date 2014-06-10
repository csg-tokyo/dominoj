package shape_pertarget;

public class UpdateDisplay {
  private int total = 0;
  public void count(int x, int y) {
    total++;
    System.out.println(this + ": total = " + total);
  }
  public static void init() {
    UpdateDisplay ud = new UpdateDisplay();
    ((Shape)$predecessor).setPosition += ud.count;
  }
  static { Shape.constructor += UpdateDisplay.init; }
}

