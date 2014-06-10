package decorator;

// the decorator
public class Decorator extends Component {
    private Component component;

    public Decorator(Component c) {
        component = c;
        // bypass some methods
        draw = component.draw;
        resize = component.resize;
    }

    // provide other functionality
    public static void main(String[] args) {
        Component c = new Component();
        Decorator d = new Decorator(c);
        d.draw();
    }
}
