package marsrover;

public class Rover {

  private Direction direction;
  private Vector position;

  public Rover(Direction direction, Vector position) {
    this.direction = direction;
    this.position = position;
  }

  public String getState() {
    return String.format("%s:%s", position.toString(), direction.getAbbreviation());
  }

  public Rover perform(Command command) {
    switch (command) {
      case LEFT:
        return new Rover(direction.turnLeft(), position);
      case RIGHT:
        return new Rover(direction.turnRight(), position);
      default:
        return new Rover(direction, position.move(direction.getTranslation()));
    }
  }

}
