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
      "NORTH, 0:0:W",
      "WEST, 0:0:S",
      "SOUTH, 0:0:E",
      "EAST, 0:0:N"})
  public void turn_left(Direction initialDirection, String expectedState) {
    var initialRover = new Rover(initialDirection);
    var newRover = initialRover.perform(LEFT);
    assertThat(newRover.getState()).isEqualTo(expectedState);
  }

  @Test
  @Parameters({
      "NORTH, 0:0:E",
      "EAST, 0:0:S",
      "SOUTH, 0:0:W",
      "WEST, 0:0:N"})
  public void turn_right(Direction initialDirection, String expectedState) {
    var initialRover = new Rover(initialDirection);
    var newRover = initialRover.perform(RIGHT);
    assertThat(newRover.getState()).isEqualTo(expectedState);
  }
}
