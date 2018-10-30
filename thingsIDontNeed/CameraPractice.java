import processing.video.*;

public class Camera{
  private Capture cam;

  if (cam.available() == true)
  {
  cam.read();
  }
  image(cam, 0, 0);

  cam.loadPixels();
  int[][] pixels = create2Dfrom1D(cam.pixels, cam.width, cam.height);

  //for(Filter f : avaliable)
//  {
  //  f.filter(pixels);
//  }

  setPixelsFrom2D(cam.pixels, pixels);
  cam.updatePixels();
}
