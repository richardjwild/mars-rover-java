package marsrover;

public class Rover {

  private Direction direction;
  private Vector position;
  private Grid world;

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
        return new Rover(direction, world.wrap(position.move(direction.getTranslation())), world);
    }
  }

}
