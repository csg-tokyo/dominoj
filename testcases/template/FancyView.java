package template;

public class FancyView extends View {
    Fancy fancy;
    public FancyView() {
        fancy = new Fancy();
        drawBorder = fancy.drawBorder;
    }
    public static void main(String[] args) {
        FancyView fv = new FancyView();
        fv.display();
    }
}

