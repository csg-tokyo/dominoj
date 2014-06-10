package proxy;

public class ImageProxy {
    private Image image;
    private String filename;
    private Integer extent = 0;
    public void fake(String f) {
        filename = f;
        System.out.println("fake loading");
    }
    public Object objLoad(Object[] args) {
        voidLoad(args);
        return null;
    }
    public void voidLoad(Object[] args) {
        if(!image.isLoaded()) {
            image.load = image.load;
            image.load(filename);
        }
    }
    public Integer getExtent() {
        if(extent == 0)    extent = $retval;
        else    System.out.println("return cached extent");
        return extent;
    }
    public ImageProxy(Image i) {
        image = i;
        image.load = this.fake;
        image.draw ^= this.voidLoad;
        image.getExtent ^= this.objLoad;
        image.getExtent += this.getExtent;
    }

    public static void main(String[] args) {
        System.out.println("-- no proxy --");
        Image i1 = new Image();
        i1.load("anImageFileName");
        i1.draw();
        i1.getExtent();

        System.out.println("-- use proxy --");
        Image i2 = new Image();
        ImageProxy proxy = new ImageProxy(i2);
        i2.load("anImageFileName");
        i2.draw();
        i2.getExtent();
        i2.getExtent = proxy.getExtent;
        i2.getExtent();
    }
}

