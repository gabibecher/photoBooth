import processing.core.*;
import processing.video.*;
import java.util.*;

public class Project extends PApplet
{
  //ArrayList<Filter> avaliable = new ArrayList<Filter>();

  //ArrayList<Filter> applied;
  private Capture cam;

  public void settings()
  {
    size(640, 480);
  }

  public void setup()
  {
    String[] cameras = Capture.list();
    if (cameras.length == 0)
    {
      println("There are no cameras available for capture.");
      exit();
    }
    else
    {
      println("Available cameras:");
      for (int i = 0; i < cameras.length; i++)
      {
        println(cameras[i]);
      }
       cam = new Capture(this, cameras[0]);
       cam.start();
     }
  }

    public void draw()
    {
      //avaliable.add(new Red());
      drawCamera();
    }

  /*public void drawImage()
  {
    photo.loadPixels();
    int[][] pixels = create2Dfrom1D(photo.pixels, photo.width, photo.height);

    for(Filter f : avaliable)
    {
      f.filter(pixels);
    }

    setPixelsFrom2D(photo.pixels, pixels);
    photo.updatePixels();
  }*/

  public int[][] create2Dfrom1D(int[] original, int rowCount, int columnCount)
  {
      // this helper function takes a 1D array as input, and returns a new 2D
      // array containing the same data

      if (original.length != rowCount * columnCount)
      {
          println("[create2Dfrom1D] Bad dimensions");
          return null;
      }

      int[][] result = new int[rowCount][columnCount];

      for (int i=0; i<rowCount; i++)
      for (int j=0; j<columnCount; j++)
          result[i][j] = original[i*columnCount + j];

      return result;
  }

  public void setPixelsFrom2D(int[] pixels, int[][] values)
  {
      // this helper function copies the values in a 2D array (values) to the
      // specified 1D array (pixels)

      if(pixels == null || values == null || values.length == 0)
      {
        println("NULL");
      }

      if (pixels.length != values.length * values[0].length)
      {
          println("[setPixelsFrom2D] Bad dimensions.");
          return;
      }

      for (int i=0; i<values.length; i++)
      for (int j=0; j<values[i].length; j++)
          pixels[i*values[0].length + j] = values[i][j];
  }

  public void drawCamera()
  {
    if (cam.available() == true)
    {
      cam.read();

      cam.loadPixels();
      int[][] pixels = create2Dfrom1D(cam.pixels, cam.width, cam.height);

      //for(Filter f : avaliable)
    //  {
      //  f.filter(pixels);
    //  }

      setPixelsFrom2D(cam.pixels, pixels);
      cam.updatePixels();

      image(cam, 0, 0);
    }
  }

  //private ArrayList<Filter> avaliable;
  //private ArrayList<Filter> applied;

  public static void main(String[] args)
  {
    PApplet.main("Project");
  }
}
