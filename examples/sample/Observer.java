package sample;

public class Observer {
  private int count;
  public void update(int i) {
    this.count++;
  }
  public static void main(String[] args) {
    Shape s = new Shape();
    Observer o = new Observer();
    s.setX += o.update;
    s.setX(10);
  }
}


