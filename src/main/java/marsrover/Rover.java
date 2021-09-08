package marsrover;

public class Rover {

  private final Direction heading;
  private final Vector position;
  private final Grid world;

  public Rover(Direction heading, Vector position, Grid world) {
    this.heading = heading;
    this.position = position;
    this.world = world;
  }

  public String getState() {
    return String.format("%s:%s", position.toString(), heading.getAbbreviation());
  }

  public Rover perform(Command command) {
    switch (command) {
      case LEFT:
        return turn(heading.getLeft());
      case RIGHT:
        return turn(heading.getRight());
      default:
        return move();
    }
  }

  private Rover turn(Direction newDirection) {
    return new Rover(newDirection, position, world);
  }

  private Rover move() {
    var translation = heading.getTranslation();
    var newPosition = position.apply(translation);
    if (world.isOccupied(newPosition))
      return new BlockedRover(heading, position, world);
    else
      return new Rover(heading, world.wrap(newPosition), world);
  }

}
