public class Red implements Filter
{
  public String name()
  {
    return "Red";
  }

 public int[][] filter(int[][] pixels)
 {
    for (int i=0; i<pixels.length; i++)
    for (int j=0; j<pixels[0].length; j++)
    {
        int red = (pixels[i][j] & 0x00ff0000) >> 16;
        int green = (pixels[i][j] & 0x0000ff00) >> 8;
        int blue = (pixels[i][j] & 0x000000ff);

        int redish = (green + blue)/2;

        pixels[i][j] = 0xFFFF0000 | redish<<16 | redish<<8 | redish;
    }
    return pixels;
  }
}
