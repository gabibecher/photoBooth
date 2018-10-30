import processing.core.*;

public class Hearts implements PhotoFilter
{
  PGraphics pg;
  private PImage hearts;
  PApplet papplet;

  public String name()
  {
    return "Hearts";
  }
  public void filter(PGraphics pg)
  {
    hearts = papplet.loadImage("hearts.png");
    papplet.imageMode(papplet.CENTER);
    pg.image(hearts, pg.width/2, pg.height/2, pg.width, pg.height);
  }
}
