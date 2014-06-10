package proceed;

public class Shape {
  public int x;
  public void setX(int nx) {
    this.x = nx;
    System.out.println("Shape: setX " + nx);
  }
  public static void main(String[] args) {
    Shape s = new Shape();
    Observer o = new Observer();
    s.setX = o.update;
    s.setX(10);
  }
}
