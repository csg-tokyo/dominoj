package state;

public class UpdateQueueState {
    private QueueEmpty empty = new QueueEmpty();
    private QueueNormal normal = new QueueNormal();
    private QueueFull full = new QueueFull();
    private Queue queue = null;
    public boolean emptyToNormal(Object o) {
        normal.insert(o);
        queue.setState(normal);
        System.out.println("UpdateQueueState: emptyToNormal");
        return $retval;
    }
    public boolean normalToFull(Object o) {
        if(normal.getFirstIdx() == normal.getLastIdx()) {
            full.setItems(normal.getItems());
            full.setFirstIdx(normal.getFirstIdx());
            queue.setState(full);
            System.out.println("UpdateQueueState: normalToFull");
        }
        return $retval;
    }
    public boolean fullToNormal() {
        normal.setItems(full.getItems());
        normal.setLastIdx(full.getFirstIdx());
        Object[] items = normal.getItems();
        normal.setFirstIdx((full.getFirstIdx()+1)%items.length);
        queue.setState(normal);
        System.out.println("UpdateQueueState: fullToNormal");
        return $retval;
    }
    public boolean normalToEmpty() {
        if(normal.getFirstIdx() == normal.getLastIdx()) {
            queue.setState(empty);
            System.out.println("UpdateQueueState: normalToEmpty");
        }
        return $retval;
    }
    public void setup(Queue q) {
        queue = q;
        queue.setState(empty);
        empty.insert += this.emptyToNormal;
        normal.insert += this.normalToFull;
        full.removeFirst += this.fullToNormal;
        normal.removeFirst += this.normalToEmpty;
    }
    public static void init() {
        Queue q = (Queue)$predecessor;
        UpdateQueueState a = new UpdateQueueState();
        a.setup(q);
    }
    static { Queue.constructor += UpdateQueueState.init; }
}
