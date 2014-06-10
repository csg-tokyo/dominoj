package extend;

public class Observer extends Component {
  public int count;
  public void update(int i) {
    this.count++;
    System.out.println("Observer: update " + i);
  }
  public void printCount() {
    System.out.println(count);
  }
}
