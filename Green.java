public class Green implements Filter
{
  public String name()
  {
    return "Green";
  }
 public int[][] filter(int[][] pixels)
 {
    for (int i=0; i<pixels.length; i++)
    for (int j=0; j<pixels[0].length; j++)
    {
        int red = (pixels[i][j] & 0x00ff0000) >> 16;
        int green = (pixels[i][j] & 0x0000ff00) >> 8;
        int blue = (pixels[i][j] & 0x000000ff);

        int greenish = (red + blue)/2;

        pixels[i][j] = 0xFF00FF00 | greenish<<16 | greenish<<8 | greenish;
    }
    return pixels;
  }
}
