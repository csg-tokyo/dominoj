package generic;

public class Screen {
    private int max_w;
    private int max_h;
    private int min_w = 0;
    private int min_h = 0;

    public Screen(int w, int h) {
        max_w = w;
        max_h = h;
    }

    // this method can be called to observe different subjects (i.e. Figure objects)
    // each subject also can be observed by different observers (i.e. Screen objects)
    public void attachSizeCheckObserver(Figure f) {
        f.resize ^= this.sizeChecker;
        System.out.println("attach sizeChecker to object " + f.hashCode());
    }
    public void detachSizeCheckObserver(Figure f) {
        f.resize -= this.sizeChecker;
        System.out.println("detach sizeChecker from object " + f.hashCode());
    }
    // use generic handler in order to modify the arguments
    public Object sizeChecker(Object[] args) {
        Integer w = (Integer)args[0];
        Integer h = (Integer)args[1];
        Boolean ret = w > max_w || w < min_w || h > max_h || h < min_h;
        if(w > max_w)    args[0] = max_w;
        if(w < min_w)    args[0] = min_w;
        if(h > max_h)    args[1] = max_h;
        if(h < min_h)    args[1] = min_h;
        System.out.println("sizeChecker: " + args[0] + ", " + args[1]);
        return ret;
    }

    // different subject-observer relations can be applied separately
    public void attachRefreshObserver(Figure f) {
        f.resize += this.refresh;
        f.setColor += this.refresh;
        System.out.println("attach refresh to object " + f.hashCode());
    }
    public void detachRefreshObserver(Figure f) {
        f.resize -= this.refresh;
        f.setColor -= this.refresh;
        System.out.println("detach refresh to object " + f.hashCode());
    }
    // bind a generic handler to two methods which have different parameters types
    public Object refresh(Object[] args) {
        if((Boolean)$retval) {
            System.out.println("refresh.");
        }
        return $retval;
    }

    public static void main(String[] args) {
        Screen s = new Screen(800, 600);
        Figure f1 = new Figure();
        Figure f2 = new Figure();
        s.attachSizeCheckObserver(f1);
        s.attachRefreshObserver(f1);
        s.attachSizeCheckObserver(f2);
        f1.resize(1024, 768);
        f1.setColor(1);
        f2.resize(640, 640);
        f2.setColor(1);
    }

}
