public class ReverseRows implements Filter
{
  public String name()
  {
    return "Reversed";
  }

  public int[][] filter(int[][] pixels)
  {
    for(int[]row : pixels)
    {
      reverseArray(row);
    }
    return pixels;
  }

  public static void reverseArray(int[] row)
  {
    int n = row.length/2;
    for(int i = 0; i < n; i++)
    {
      int temp = row[i];
      row[i] = row[row.length - (i+1)];
      row[row.length - (i+1)] =  temp;
    }
  }
}
