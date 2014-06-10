package predecessor;

public class Shape {
  public int left = 0; public int top = 0;
  public void setPosition(int x, int y) {
    left = x; top = y;
  }
  public void moving() {
    System.out.println("moving");
  }
  public void moved() {
    System.out.println("moved");
  }
  public Shape() {
    this.setPosition ^= Move.onMoving;
    this.setPosition += Move.onMoved;
  }
  public static void main(String[] args) {
      Shape s = new Shape();
      s.setPosition(0, 0);
  }
}

