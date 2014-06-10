package shape_aspect;

public class UpdateDisplay {
  public static void init() {
    ((Shape)$predecessor).setPosition += Display.refresh;
  }
  static { Shape.constructor += UpdateDisplay.init; }
}

