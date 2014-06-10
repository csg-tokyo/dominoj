package extend;

public class Shape {
  public int x;
  public void setX(int nx) {
    this.x = nx;
    System.out.println("Shape: setX " + nx);
  }
  public static void main(String[] args) {
    Shape s = new Shape();
    Observer o = new Observer();
    s.setX += o.test;
    s.setX(10);
  }
}
