package generic;

public class Figure extends Object {
    private int width = 0;
    private int height = 0;
    private int color = 0;
    public boolean resize(int w, int h) {
        if(w == width && h == height)    return false;
        width = w;
        height = h;
        return true;
    }
    public boolean setColor(int c) {
        if(c == color)    return false;
        color = c;
        return true;
    }
}
