package template;

public class View {
    public void display() {
        drawBorder();
        drawContent();
    }
    public void drawBorder() {
        System.out.println("View: drawBorder");
    }
    public void drawContent() {
        System.out.println("View: drawContent");
    }
}

