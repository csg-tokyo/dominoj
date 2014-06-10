package component;

public class Component {
  private String name = "";
  private Component parent = null;
  private int left = 0; private int top = 0;
  private int width = 0; private int height = 0;
  public void changed(Object[] args) {}
  public void setPosition(int x, int y) {
    left = x; top = y;
  }
  public void setSize(int w, int h) {
    width = w; height = h;
  }
  public void redraw (Object[] args) {
    System.out.println(name + ": redraw.");
    // redraw itself
  }
  public Component(String n, Component p) {
    name = n; parent = p;
    setPosition += changed;
    setSize += changed;
    changed += redraw;
    if (parent != null) { parent.changed += redraw; }
  }
  public static void main(String[] args) {
    Component parent = new Component("parent", null);
    Component child1 = new Component("child 1", parent);
    Component child2 = new Component("child 2", parent);
    parent.setPosition(10, 10);
    parent.setSize(10, 10);
  }
}
