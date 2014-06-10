package state;

public class QueueFull extends QueueState {
    private Object[] items;
    private int first;
    public int getFirstIdx() {
        return first;
    }
    public void setFirstIdx(int f) {
        first = f;
    }
    public Object[] getItems() {
        return items;
    }
    public void setItems(Object[] i) {
        items = i;
    }
    public boolean insert(Object o) {
        return false;
    }
    public Object getFirst() {
        return items[first];
    }
    public boolean removeFirst() {
        return true;
    }
}
