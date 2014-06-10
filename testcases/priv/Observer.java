package priv;

public class Observer {
    String name;

    public Observer() {
        name = getClass().getName();
        this.a += this.b;
    }

    public void print(String str) {
        System.out.println(name + ": " + str);
    }

    private void a() {
        print("a");
    }

    private void b() {
        print("b");
    }

    public void c() {
        print("c");
    }

    public static void main(String[] args) {
        Observer o = new Observer();
        Subject s = new Subject();
        o.a();
        s.a += o.c;  // ok
        //s.a += o.b;  // error, the right one is private
        //s.b += o.c;  // error, the left one is private
        s.a();
    }
}
