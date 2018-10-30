import processing.core.*;
import processing.video.*;
import java.util.*; //use array on side, use up and down keys to change thro

public class Project extends PApplet
{
  ArrayList<Filter> avaliable = new ArrayList<Filter>(); //use a pgraphics to have a preview image on screen w avaliable filters listed with their number, then draw over image filters
  ArrayList<Filter> applied = new ArrayList<Filter>();
  ArrayList<PhotoFilter> avaliablePhoto = new ArrayList<PhotoFilter>(); //use a pgraphics to have a preview image on screen w avaliable filters listed with their number, then draw over image filters
  ArrayList<PhotoFilter> appliedPhoto = new ArrayList<PhotoFilter>();

  private Capture cam;
  PGraphics pg;
  int current = 0;
  int currentPhoto = 0;
//  int index = 0;

  public void settings()
  {
    fullScreen();
  }

  public void setup()
  {
    background(255);

    pg = createGraphics(width, height);

    avaliable.add(new Invert());
    avaliable.add(new Blue());
    avaliable.add(new Green());
    avaliable.add(new Red());
    avaliable.add(new Ocean());
  //  avaliable.add(new UpsideDown());
  //  avaliablePhoto.add(new Hearts());

    //avaliablePhoto.add(new Text());



  /*  avaliable.add(new Purple());
    avaliable.add(new Yellow());
    avaliable.add(new ReverseRows());*/

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
      //width : 1440 height : 900
      pg.beginDraw();
      drawCamera();
      pg.endDraw();

      imageMode(CENTER);
      image(pg, width*1/2, height*1/2, width*1/2, height*1/2);

      /*if(current != 0)
      {
        stroke(255,200,200);
        strokeWeight(10);
        line(width*0, height*((current)/20), width*3/10, height*((current)/20));
      }*/

    //  String test = "current " + current;
      //text(test, width*1/2, height *1/2);

      textSize(30);
      fill(50);
      text("xray", width*0, height*1/20);
      text("blue", width*0, height*2/20);
      text("green", width*0, height*3/20);
      text("red", width*0, height*4/20);
      text("ocean", width*0, height*5/20);
      //text("upside down", width*0, height*6/20);

      //text("hello", width*7/8, height*1/20);
      //text("hearts", width*7/8, height*2/20);

      text("By: Gabi Becher", width*6/8, height*19/20);



    /*  text("purple", width*0, height*7/20);
      text("yellow", width*0, height*8/20);
      text("reverse", width*0, height*9/20);


      /*for(int x = 0; x<avaliable.size()-1; x++)
      {
        int yPos = (x+1)/20;
        String nameText = (avaliable.get(x)).name();
        text(nameText, width*0, height*yPos);
      }*/

      if(current == 0)
      {
        if(applied.size() != 0)
          {applied.remove(applied.size()-1);}
        fill(255,200,200);
        text("xray", width*0, height*1/20);
        applied.add(avaliable.get(current));
      }
      if(current == 1)
      {
        applied.remove(applied.size()-1);
        fill(255,200,200);
        text("blue", width*0, height*2/20);
        applied.add(avaliable.get(current));
      }
      if(current == 2)
      {
        applied.remove(applied.size()-1);
        fill(255,200,200);
        text("green", width*0, height*3/20);
        applied.add(avaliable.get(current));
      }
      if(current == 3)
      {
        applied.remove(applied.size()-1);
        fill(255,200,200);
        text("red", width*0, height*4/20);
        applied.add(avaliable.get(current));
      }
      if(current == 4)
      {
        applied.remove(applied.size()-1);
        fill(255,200,200);
        text("ocean", width*0, height*5/20);
        applied.add(avaliable.get(current));
      }
  /*    if(current == 5)
      {
        applied.remove(applied.size()-1);
        fill(255,200,200);
        text("upside down", width*0, height*6/20);
        applied.add(avaliable.get(current));
      }*/


    /*  if(currentPhoto == 0)
      {
        fill(255,200,200);
        text("hello", width*7/8, height*1/20);
        appliedPhoto.add(avaliablePhoto.get(current));
      }
      if(currentPhoto == 1)
      {
        fill(255,200,200);
        appliedPhoto.remove(appliedPhoto.size()-1);
        text("hearts", width*7/8, height*2/20);
        appliedPhoto.add(avaliablePhoto.get(current));
      }*/
    /*  if(current == 6)
      {
        applied.remove(applied.size()-1);
        fill(255,200,200);
        text("purple", width*0, height*7/20);
        applied.add(avaliable.get(current));
      }
      if(current == 7)
      {
        applied.remove(applied.size()-1);
        fill(255,200,200);
        text("yellow", width*0, height*8/20);
        applied.add(avaliable.get(current));
      }
      if(current == 8)
      {
        applied.remove(applied.size()-1);
        fill(255,200,200);
        text("reverse", width*0, height*9/20);
        applied.add(avaliable.get(current));
      }*/
    }

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

      for(Filter f : applied)
      {
        pixels = f.filter(pixels);
      }

    /*  for(PhotoFilter x : appliedPhoto)
      {
        x.filter(pg);
      }*/

      setPixelsFrom2D(cam.pixels, pixels);
      cam.updatePixels();

      pg.image(cam, 0, 0);
    }
  }

  private int x = 0;
  public void savePhoto() //saves to project folder
  {
      System.out.println("hello");
    saveFrame("photo" + x + ".jpg");
    x++;
  }

  public void keyPressed()
  {
      if(keyCode == DOWN)
      {
        if (current < avaliable.size()-1)
          {
            current++;
          }
      }
      if(keyCode == UP)
      {
        if (current > 0)
          {
            current--;
          }
      }
      if (key == ' ')
          savePhoto();
  }

  public static void main(String[] args)
  {
    PApplet.main("Project");
  }
}
