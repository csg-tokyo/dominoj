package supercall;

public class Child extends Parent {
    public void test() {
        super.test();
        super.test2();
        System.out.println("Child.test");
    }

    public static void main(String[] args) {
        Child child = new Child();
        child.test();
    }
}
