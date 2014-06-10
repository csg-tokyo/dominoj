package retval;

public class Observer {
    String name;

    public Observer() {
        name = getClass().getName();
    }
    
    public void print(String str) {
        System.out.println(name + ": " + str);
    }

    public boolean a() {
        print("a " + $retval);
        return true;
    }

    public int b() {
        print("b " + $retval);
        return 1;
    }

    public Observer c() {
        print("c " + $retval);
        return new Observer();
    }

    public Object d(Object[] args) {
        print("d " + $retval);
        return $retval;
    }

    public static void main(String[] args) {
        System.out.println("-- default value --");
        Observer o = new Observer();
        o.a();
        o.b();
        o.c();
        System.out.println("-- from predecessor --");
        Subject s = new Subject();
        s.a += o.a;
        s.b += o.b;
        s.c += o.c;
        s.a += o.d;
        s.b += o.d;
        s.c += o.d;
        s.a();
        s.b();
        s.c();
    }
}
