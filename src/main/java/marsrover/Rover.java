package marsrover;

public class Rover {

  public Rover(Direction direction) {

  }

  public String getState() {
    return null;
  }

  public Rover perform(Command command) {
    return this;
  }

  public Direction getDirection() {
    return Direction.WEST;
  }
}
