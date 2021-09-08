package marsrover;

import static marsrover.Direction.SOUTH;
import static marsrover.Direction.WEST;

public class Rover {

  private Direction direction;

  public Rover(Direction direction) {
    this.direction = direction;
  }

  public String getState() {
    return null;
  }

  public Rover perform(Command command) {
    if (direction == Direction.NORTH)
      return new Rover(WEST);
    else
      return new Rover(SOUTH);
  }

  public Direction getDirection() {
    return direction;
  }
}
