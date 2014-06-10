package state;

public class Queue {
    private QueueState state = null;
    public void setState(QueueState s) {
        state = s;
    };
    public boolean insert(Object o) {
        return state.insert(o);
    }
    public Object getFirst() {
        return state.getFirst();
    }
    public boolean removeFirst() {
        return state.removeFirst();
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        System.out.println("-- insertion --");
        System.out.println("insertion 1 -> " + q.insert("1"));
        System.out.println("insertion 2 -> " + q.insert("2"));
        System.out.println("insertion 3 -> " + q.insert("3"));
        System.out.println("insertion 4 -> " + q.insert("4"));
        System.out.println("-- removal --");
        System.out.println("removal 1 -> " + q.removeFirst());
        System.out.println("removal 2 -> " + q.removeFirst());
        System.out.println("removal 3 -> " + q.removeFirst());
        System.out.println("removal 4 -> " + q.removeFirst());
    }
}
