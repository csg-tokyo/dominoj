package constructor;

public class Observer {
  public void test() {
    System.out.println("an instance of Shape is constructed.");
  }
  public static void main(String[] args) {
    Observer o = new Observer();
    Shape.constructor += o.test;
    Shape s = new Shape();
  }
}
