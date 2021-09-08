package marsrover;

public class Obstacle {

  private final Vector position;

  public Obstacle(int x, int y) {
    this.position = new Vector(x, y);
  }

  public boolean isOccupying(Vector position) {
    return this.position.equals(position);
  }
}
