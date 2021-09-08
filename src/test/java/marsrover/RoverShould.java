package marsrover;

import static marsrover.Command.LEFT;
import static marsrover.Command.RIGHT;
import static org.assertj.core.api.Assertions.assertThat;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class RoverShould {

  @Test
  @Parameters({
      "NORTH, WEST",
      "WEST, SOUTH",
      "SOUTH, EAST",
      "EAST, NORTH"})
  public void turn_left(Direction initialDirection, Direction expectedDirection) {
    var initialRover = new Rover(initialDirection);
    var newRover = initialRover.perform(LEFT);
    assertThat(newRover.getDirection()).isEqualTo(expectedDirection);
  }

  @Test
  @Parameters({
      "NORTH, EAST",
      "EAST, SOUTH"})
  public void turn_right(Direction initialDirection, Direction expectedDirection) {
    var initialRover = new Rover(initialDirection);
    var newRover = initialRover.perform(RIGHT);
    assertThat(newRover.getDirection()).isEqualTo(expectedDirection);
  }
}
