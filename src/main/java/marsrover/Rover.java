package marsrover;

import static marsrover.Command.LEFT;
import static marsrover.Command.RIGHT;

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
    if (command == LEFT)
      return new Rover(direction.turnLeft(), position);
    else if (command == RIGHT)
      return new Rover(direction.turnRight(), position);
    else
      return new Rover(direction, position.move(direction.getTranslation()));
  }

}
