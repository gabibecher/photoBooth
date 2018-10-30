
import processing.core.*;


public class ScoreTest extends PApplet
{

  int score = 0;

  public void settings()
  {
     size(400, 400);
  }


  public void draw()
  {
     background(0);
     fill(255);
     text(score, 100, 100);
  }


  public void keyPressed()
  {
     if (keyCode == DOWN)
         score++;
     else if (keyCode == UP)
         score--;
  }

  public static void main(String[] args)
  {
     PApplet.main("ScoreTest");
  }
}
