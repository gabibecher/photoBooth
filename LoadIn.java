import processing.core.*;

public class LoadIn extends PApplet
{
    public void settings()
    {
        size(800, 600);
    }

    public void setup()
    {
        imageMode(CENTER);
        loadImage();
    }

    public void draw()
    {
        background(0);
        image(photo, width/2, height/2);
      //pixel interface and drawing interface pgraphics
      //draiwng -- pass pgraphics object // array list of filters
    }

    public int[][] create2Dfrom1D(int[] original, int rowCount, int columnCount) //seperate class static
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

        if (pixels.length != values.length * values[0].length)
        {
            println("[setPixelsFrom2D] Bad dimensions.");
            return;
        }

        for (int i=0; i<values.length; i++)
        for (int j=0; j<values[i].length; j++)
            pixels[i*values[0].length + j] = values[i][j];
    }

  /*  public void 3d()
    {
      image.Blue(photo, width/3, height/2);
      image.Red(photo, width/3, height/2);
    }*/

    public void Red()
    {
        // load the pixels into a 2D array

        photo.loadPixels();
        int[][] pixels = create2Dfrom1D(photo.pixels, photo.width, photo.height);

        // manipulate the 2D array

        for (int i=0; i<pixels.length; i++)
        for (int j=0; j<pixels[0].length; j++)
        {
            int red = (pixels[i][j] & 0x00ff0000) >> 16;
            int green = (pixels[i][j] & 0x0000ff00) >> 8;
            int blue = (pixels[i][j] & 0x000000ff);

            //int redish = red + ((green + blue)/5);

            int grey = (green + blue)/2;

            pixels[i][j] = 0xffff0000 | red<<16 | grey<<8 | grey;
        }

        // copy the 2D array back to the image pixel array

        setPixelsFrom2D(photo.pixels, pixels);
        photo.updatePixels();
    }

        public void Blue() //input 2darray list pgraphics (pixel filter)
        {
            photo.loadPixels();
            int[][] pixels = create2Dfrom1D(photo.pixels, photo.width, photo.height);

            for (int i=0; i<pixels.length; i++)
            for (int j=0; j<pixels[0].length; j++)
            {
                int red = (pixels[i][j] & 0x00ff0000) >> 16;
                int green = (pixels[i][j] & 0x0000ff00) >> 8;
                int blue = (pixels[i][j] & 0x000000ff);

                int grey = (red + blue)/2;

                pixels[i][j] = 0xff0000ff | grey<<16 | grey<<8 | blue;
            }

            setPixelsFrom2D(photo.pixels, pixels);
            photo.updatePixels();
        }

    public void keyPressed()
    {
      if (key == 'b')
      {
          Blue();
      }

        if (key == 'r')
        {
            Red();
        }

        else if (key == 'c')
        {
            loadImage();
        }
    }

    private void loadImage()
    {
        photo = loadImage("Catherine.jpg");
        photo.resize((int)(width*.95), 0);
    }

    private PImage photo;

    public static void main(String[] args)
    {
        PApplet.main("LoadIn");
    }
}
