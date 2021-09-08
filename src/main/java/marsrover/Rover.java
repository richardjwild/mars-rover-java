package marsrover;

import static marsrover.Direction.EAST;
import static marsrover.Direction.NORTH;
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
    if (direction == NORTH)
      return new Rover(WEST);
    else if (direction == WEST)
      return new Rover(SOUTH);
    else if (direction == SOUTH)
      return new Rover(EAST);
    else
      return new Rover(NORTH);
  }

  public Direction getDirection() {
    return direction;
  }
}
