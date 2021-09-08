package marsrover;

public class Grid {

  private int sizeX;
  private int sizeY;

  public Grid(int sizeX, int sizeY) {
    this.sizeX = sizeX;
    this.sizeY = sizeY;
  }

  public Vector wrap(Vector position) {
    int x = wrap(position.x, sizeX);
    int y = wrap(position.y, sizeY);
    return new Vector(x, y);
  }

  private int wrap(int value, int size) {
    if (value >= size)
      return value - size;
    else if (value < 0)
      return value + size;
    else return value;
  }
}
