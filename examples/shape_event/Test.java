package shape_event;

public class Test {
  public static void main(String[] args) {
    Display d = new Display();
    Shape s = new Shape(d);
    s.setPosition(0, 0);
  }
}

