package proceed;

public class Observer {
  public int count;
  public void update(int i) {
    this.count++;
    System.out.println("Observer: update " + i);
    proceed(1);
    System.out.println("Observer: update after proceed " + i);
  }
  public void printCount() {
    System.out.println(count);
  }
}
