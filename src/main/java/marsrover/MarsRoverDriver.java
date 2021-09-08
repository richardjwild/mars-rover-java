package marsrover;

import static marsrover.Direction.NORTH;

public class MarsRoverDriver {

  private static final Direction INITIAL_DIRECTION = NORTH;
  private static final Vector INITIAL_POSITION = new Vector(0, 0);
  private static final Grid WORLD = new Grid(10, 10);

  public MarsRoverDriver(Obstacle... obstacles) { }

  public Rover drive(String commands) {
    var rover = new Rover(INITIAL_DIRECTION, INITIAL_POSITION, WORLD);
    for (var c: commands.toCharArray()) {
      rover = rover.perform(Command.from(c));
    }
    return rover;
  }
}
