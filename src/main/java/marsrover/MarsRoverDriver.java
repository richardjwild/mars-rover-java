package marsrover;

import static marsrover.Direction.NORTH;

public class MarsRoverDriver {

  public MarsRoverDriver(Obstacle... obstacles) { }

  public Rover drive(String commands) {
    var rover = new Rover(NORTH, new Vector(0, 0));
    for (var c: commands.toCharArray()) {
      rover = rover.perform(Command.from(c));
    }
    return rover;
  }
}
