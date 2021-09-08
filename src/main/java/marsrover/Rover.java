package marsrover;

import static marsrover.Command.LEFT;

public class Rover {

  private Direction direction;

  public Rover(Direction direction) {
    this.direction = direction;
  }

  public String getState() {
    return null;
  }

  public Rover perform(Command command) {
    if (command == LEFT)
      return new Rover(direction.turnLeft());
    else
      return new Rover(direction.turnRight());
  }

  public Direction getDirection() {
    return direction;
  }
}
