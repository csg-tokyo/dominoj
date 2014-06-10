package caller;

public class X {
    public void test() {
        System.out.println("[x] $caller: " + $caller + ", $predecessor: " + $predecessor + ", $self: " + $self);
    }
    public void test2() {
        this.test();
    }
    public static void main(String[] args) {
        X x = new X();
        Y y = new Y();
        Z z = new Z();
        x.test += y.test;
        y.test += z.test;
        x.test2();
    }
}
