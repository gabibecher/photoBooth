import processing.core.*;

public class ConvertArray
{
  public int[][] create2Dfrom1D(int[] original, int rowCount, int columnCount) //seperate class static
  {
      // this helper function takes a 1D array as input, and returns a new 2D
      // array containing the same data

      if (original.length != rowCount * columnCount)
      {
          System.out.println("[create2Dfrom1D] Bad dimensions");
          return null;
      }

      int[][] result = new int[rowCount][columnCount];

      for (int i=0; i<rowCount; i++)
      for (int j=0; j<columnCount; j++)
          result[i][j] = original[i*columnCount + j];

      return result;
  }

  public void setPixelsFrom2D(int[] pixels, int[][] values)
  {
      // this helper function copies the values in a 2D array (values) to the
      // specified 1D array (pixels)

      if (pixels.length != values.length * values[0].length)
      {
          System.out.println("[setPixelsFrom2D] Bad dimensions.");
          return;
      }

      for (int i=0; i<values.length; i++)
      for (int j=0; j<values[i].length; j++)
          pixels[i*values[0].length + j] = values[i][j];
  }
}
