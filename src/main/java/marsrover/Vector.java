package marsrover;

public class Vector {

  private final int x;
  private final int y;

  public Vector(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public Vector move(Vector translation) {
    return new Vector(x + translation.x, y + translation.y);
  }

  public String toString() {
    return String.format("%d:%d", x, y);
  }

}
