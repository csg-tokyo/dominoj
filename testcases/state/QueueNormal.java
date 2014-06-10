package state;

public class QueueNormal extends QueueState {
    private Object[] items = new Object[3];
    private int first = 0;
    private int last = 0;
    public int getFirstIdx() {
        return first;
    }
    public void setFirstIdx(int f) {
        first = f;
    }
    public int getLastIdx() {
        return last;
    }
    public void setLastIdx(int l) {
        last = l;
    }
    public Object[] getItems() {
        return items;
    }
    public void setItems(Object[] i) {
        items = i;
    }
    public boolean insert(Object o) {
        items[last] = o;
        last = (last+1)%items.length;
        return true;
    }
    public Object getFirst() {
        return items[first];
    }
    public boolean removeFirst() {
        first = (first+1)%items.length;
        return true;
    }
}
