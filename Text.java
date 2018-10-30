import processing.core.*;

public class Text implements PhotoFilter
{
  PGraphics pg;

  public String name()
  {
    return "Hello";
  }
  public void filter(PGraphics pg)
  {
    pg.textSize(50);
    pg.text("HELLO", pg.width*1/2, pg.height*1/2);
  }
}
