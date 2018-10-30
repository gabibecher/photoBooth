public class Blue implements Filter
{
 public String name()
 {
   return "Blue";
 }

 public int[][] filter(int[][] pixels)
 {
    for (int i=0; i<pixels.length; i++)
    for (int j=0; j<pixels[0].length; j++)
    {
        int red = (pixels[i][j] & 0x00ff0000) >> 16;
        int green = (pixels[i][j] & 0x0000ff00) >> 8;
        int blue = (pixels[i][j] & 0x000000ff);

        int blueish = (red + green)/2;

        pixels[i][j] = 0xff0000ff | blueish<<16 | blueish<<8 | blue;
    }
    return pixels;
  }
}
