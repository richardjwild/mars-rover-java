package marsrover;

import static marsrover.Command.LEFT;
import static marsrover.Command.MOVE;
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
    var initialRover = new Rover(initialDirection, new Vector(0, 0), new Grid(2, 2));
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
    var initialRover = new Rover(initialDirection, new Vector(0, 0), new Grid(2, 2));
    var newRover = initialRover.perform(RIGHT);
    assertThat(newRover.getState()).isEqualTo(expectedState);
  }

  @Test
  @Parameters({
      "NORTH, 1:2:N",
      "EAST, 2:1:E",
      "SOUTH, 1:0:S",
      "WEST, 0:1:W"})
  public void move(Direction initialDirection, String expectedState) {
    var initialRover = new Rover(initialDirection, new Vector(1, 1), new Grid(3, 3));
    var newRover = initialRover.perform(MOVE);
    assertThat(newRover.getState()).isEqualTo(expectedState);
  }

  @Test
  @Parameters({
      "NORTH, 0, 1, 0:0:N",
      "SOUTH, 0, 0, 0:1:S",
      "WEST, 0, 0, 1:0:W",
      "EAST, 1, 0, 0:0:E"
  })
  public void wrap_when_passing_off_edge_of_the_grid(Direction heading, int x, int y,
      String expectedState) {
    var initialRover = new Rover(heading, new Vector(x, y), new Grid(2, 2));
    var newRover = initialRover.perform(MOVE);
    assertThat(newRover.getState()).isEqualTo(expectedState);
  }

}
