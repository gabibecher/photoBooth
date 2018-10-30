public class DrawCamera
{
public void drawCamera()
{
  if (cam.available() == true)
  {
    cam.read();

    cam.loadPixels();
    int[][] pixels = create2Dfrom1D(cam.pixels, cam.width, cam.height);

    for(Filter f : avaliable)
    {
      f.filter(pixels);
    }

    setPixelsFrom2D(cam.pixels, pixels);
    cam.updatePixels();

    image(cam, 0, 0);
  }
}
}
