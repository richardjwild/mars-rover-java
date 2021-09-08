package marsrover;

public class Vector {

  public final int x;
  public final int y;

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

  public boolean equals(Vector other) {
    return x == other.x && y == other.y;
  }
}
