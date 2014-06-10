package priv;

public class Subject {
    String name;

    public Subject() {
        name = getClass().getName();
    }
    
    public void print(String str) {
        System.out.println(name + ": " + str);
    }

    public void a() {
        print("a");
    }

    private void b() {
        print("b");
    }

    private void c() {
        print("c");
    }
}
