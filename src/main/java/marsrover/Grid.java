package marsrover;

import static java.util.Collections.emptyList;

import java.util.List;

public class Grid {

  private int sizeX;
  private int sizeY;
  private final List<Obstacle> obstacles;

  public Grid(int sizeX, int sizeY, List<Obstacle> obstacles) {
    this.sizeX = sizeX;
    this.sizeY = sizeY;
    this.obstacles = obstacles;
  }

  public Grid(int sizeX, int sizeY) {
    this(sizeX, sizeY, emptyList());
  }

  public Vector wrap(Vector position) {
    int x = wrapValue(position.x, sizeX);
    int y = wrapValue(position.y, sizeY);
    return new Vector(x, y);
  }

  private int wrapValue(int value, int size) {
    if (value >= size)
      return value - size;
    else if (value < 0)
      return value + size;
    else return value;
  }

  public boolean isOccupied(Vector position) {
    return obstacles.stream()
        .anyMatch(obstacle -> obstacle.isOccupying(position));
  }
}
