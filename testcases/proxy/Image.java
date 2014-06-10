package proxy;

public class Image {
    private String filename = "";
    public void load(String f) {
        filename = f;
        System.out.println("load " + f);
    }
    public boolean isLoaded() {
        return filename.length()!=0;
    }
    public void draw() {
        if(isLoaded())    System.out.println("draw");
        else    System.out.println("not loaded");
    }
    public Integer getExtent() {
        if(isLoaded())    System.out.println("getExtent");
        else    System.out.println("not loaded");
        return 1;
    }
}
