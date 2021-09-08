package marsrover;

public class Rover {

  private Direction direction;

  public Rover(Direction direction) {
    this.direction = direction;
  }

  public String getState() {
    return null;
  }

  public Rover perform(Command command) {
    return new Rover(direction.turnLeft());
  }

  public Direction getDirection() {
    return direction;
  }
}
