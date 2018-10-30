public class Ocean implements Filter
{
  public String name()
  {
    return "Ocean";
  }

  public int[][] filter(int[][] pixels)
  {
  for (int i=0; i<pixels.length; i++)
  for (int j=0; j<pixels[0].length; j++)
    {
      pixels[i][j] &= 0x0ffff;
    }
    return pixels;
  }
}
