public class Invert implements Filter //blinking
{
  public String name()
  {
    return "Xray";
  }

  public int[][] filter(int[][] pixels)
  {
    for (int i=0; i<pixels.length; i++)
    for (int j=0; j<pixels[0].length; j++)
    {
      int red = (pixels[i][j] & 0x00ff0000) >> 16;
      int green = (pixels[i][j] & 0x0000ff00) >> 8;
      int blue = (pixels[i][j] & 0x000000ff);

      int r = 255 - red;
      int g = 255- green;
      int b = 255 - blue;

      pixels[i][j] = 0xff000000 | (r<<16) | (g<<8) | b;
    }
    return pixels;
  }
}
