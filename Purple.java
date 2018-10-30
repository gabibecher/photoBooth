public class Purple implements Filter //too opaque
{
  public String name()
  {
    return "Purple";
  }
 public int[][] filter(int[][] pixels)
 {
    for (int i=0; i<pixels.length; i++)
    for (int j=0; j<pixels[0].length; j++)
    {
        int red = (pixels[i][j] & 0x00ff0000) >> 16;
        int green = (pixels[i][j] & 0x0000ff00) >> 8;
        int blue = (pixels[i][j] & 0x000000ff);

        int purpleish = (green)/3;

        pixels[i][j] = 0xFFFF00FF | purpleish<<16 | purpleish<<8 | purpleish;
    }
    return pixels;
  }
}
