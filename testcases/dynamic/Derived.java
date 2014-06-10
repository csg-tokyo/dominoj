package dynamic;

public class Derived extends Base {
    public void method() {
        System.out.println("Derived");
    }
    public void handler() {
        System.out.println("handler");
    }
    public static void main(String[] args) {
        Base b = new Derived();
        Derived d = (Derived)b;
        b.method += d.handler;
        b.method();
    }
}
