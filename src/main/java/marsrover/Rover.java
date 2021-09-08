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
        return new Rover(direction.turnLeft(), position, world);
      case RIGHT:
        return new Rover(direction.turnRight(), position, world);
      default:
        return move();
    }
  }

  private Rover move() {
    Vector translation = direction.getTranslation();
    Vector newPosition = position.move(translation);
    if (world.isOccupied(newPosition))
      return new BlockedRover(direction, position, world);
    else
      return new Rover(direction, world.wrap(newPosition), world);
  }

}
