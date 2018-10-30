import processing.core.*;

public interface Filter
{
  public String name();
  public int[][] filter(int[][] pixels);
}
