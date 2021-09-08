package marsrover;

public class Rover {

  private final Direction direction;
  private final Vector position;
  private final Grid world;

  public Rover(Direction direction, Vector position, Grid world) {
    this.direction = direction;
    this.position = position;
    this.world = world;
  }

  public String getState() {
    return String.format("%s:%s", position.toString(), direction.getAbbreviation());
  }

  public Rover perform(Command command) {
    switch (command) {
      case LEFT:
        return turn(direction.getLeft());
      case RIGHT:
        return turn(direction.getRight());
      default:
        return move();
    }
  }

  private Rover turn(Direction newDirection) {
    return new Rover(newDirection, position, world);
  }

  private Rover move() {
    var translation = direction.getTranslation();
    var newPosition = position.apply(translation);
    if (world.isOccupied(newPosition))
      return new BlockedRover(direction, position, world);
    else
      return new Rover(direction, world.wrap(newPosition), world);
  }

}
