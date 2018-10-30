public void drawImage()
  {
    photo.loadPixels();
    int[][] pixels = create2Dfrom1D(photo.pixels, photo.width, photo.height);

    for(Filter f : avaliable)
    {
      f.filter(pixels);
    }

    setPixelsFrom2D(photo.pixels, pixels);
    photo.updatePixels();
  }
