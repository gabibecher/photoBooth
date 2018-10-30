public class UpsideDown implements Filter
{
  public String name()
  {
    return "Upside down";
  }
  public int[][] filter(int[][] pixels)
  {
    int[][] result = new int[pixels.length][pixels[0].length];
    //System.out.println("upside down is applied");

    for (int i=0; i<pixels.length; i++)
    {
        for (int j=0; j<pixels[i].length; j++)
        {
          //result[i][j] = pixels[i][j] & 0xff0000;
          //result[i][j] = pixels[pixels.length-i-1][j];
          result[i][j] = pixels[i][pixels[0].length-j-1];
        }
     }
    return result;
  }


  
}
