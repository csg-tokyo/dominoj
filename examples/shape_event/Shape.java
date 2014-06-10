package shape_event;

public class Shape {
  private int left = 0; private int top = 0;
  public void setPosition(int x, int y) {
    left = x; top = y;
  }
  public Shape(Display d) {
    setPosition += d.refresh;
  }
}

