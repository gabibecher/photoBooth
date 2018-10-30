public class MirrorRightLeft implements Filter //dont use, not finished
{
  public String name()
  {
    return "Horizontal Mirror";
  }

  public int[][] filter(int[][] pixels)
  {
     int leftPixel = null;
     int rightPixel = null;
     int width = pixels[0].length;
     for (int row = 0; row < pixels.length; row++)
     {
       for (int col = 0; col < width / 2; col++)
       {
       leftPixel = pixels[row][col];
       rightPixel = pixels[row][width - col - 1];
       leftPixel.setColor(rightPixel.getColor());
       }
     }
    }
  }
