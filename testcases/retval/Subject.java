package retval;

public class Subject {
    String name;

    public Subject() {
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

}
