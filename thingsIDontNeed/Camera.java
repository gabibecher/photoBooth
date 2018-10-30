import processing.core.*;
import processing.video.*;

public class Camera
{
   private PApplet papplet;

   public void draw()
   {
     if (cam.available() == true)
     {
     cam.read();
     }
     image(cam, 0, 0);
   }

   public void mousePressed()
   {
     cam.stop();

     if(keyCode == RIGHT)
     {
       saveFrame("file_name.jpg");
     }
   }

  // private static String[] commandLineArgs;

    public static void main(String[] args)
    {
      //  commandLineArgs = args;
        PApplet.main("Camera");
    }
}
