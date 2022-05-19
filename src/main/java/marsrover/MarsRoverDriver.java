package marsrover;

public class MarsRoverDriver {

  private Rover rover;

  public MarsRoverDriver(Environment environment) {
    this.rover = new NorthFacingRover(0, 0, environment);
  }

  public Rover drive(String commands) {
    for (char command: commands.toCharArray()) {
      execute(command);
    }
    return rover;
  }

  private void execute(char command) {
    if (command == 'L')
      rover = rover.turnLeft();
    else if (command == 'R')
      rover = rover.turnRight();
    else if (command == 'M')
      rover = rover.move();
  }
}
