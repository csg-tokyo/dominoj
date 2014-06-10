package state;

public class QueueEmpty extends QueueState {
    public boolean insert(Object o) {
        return true;
    }
    public Object getFirst() {
        return null;
    }
    public boolean removeFirst() {
        return false;
    }
}
