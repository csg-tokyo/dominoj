package decorator;

public class Component {
    String name;
    public Component() {
        name = getClass().getName();
    }
    public void draw() {
        System.out.println(name + ": draw");
    }
    public void resize() {
        System.out.println(name + ": resize");
    }
}

