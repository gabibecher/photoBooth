import processing.core.*;

public interface Filter
{
  public void transformImage()
  {
      photo.loadPixels();
      int[][] pixels = create2Dfrom1D(photo.pixels, photo.width, photo.height);

      for (int i=0; i<pixels.length; i++)
      for (int j=0; j<pixels[0].length; j++)
      {
          int red = (pixels[i][j] & 0x00ff0000) >> 16;
          int green = (pixels[i][j] & 0x0000ff00) >> 8;
          int blue = (pixels[i][j] & 0x000000ff);

          int grey = (red + green + blue)/3;

          pixels[i][j] = 0xff000000 | grey<<16 | grey<<8 | grey;
      }

      setPixelsFrom2D(photo.pixels, pixels);
      photo.updatePixels();
  }
}
