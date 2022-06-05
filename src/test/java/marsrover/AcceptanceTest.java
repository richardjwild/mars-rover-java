package marsrover;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class AcceptanceTest {

  @Test
  public void mars_rover_drives_around() {
    var marsRoverDriver = new RoverDriver();
    var rover = marsRoverDriver.drive("MMRMMLM");
    assertThat(rover.getState()).isEqualTo("2:3:N");
  }

  @Test
  public void mars_rover_wraps_around_at_edge_of_grid() {
    var marsRoverDriver = new RoverDriver();
    var rover = marsRoverDriver.drive("MMMMMMMMMM");
    assertThat(rover.getState()).isEqualTo("0:0:N");
  }

  @ParameterizedTest
  @CsvSource({
      "MMMM,O:0:2:N",
      "RMMMMMMMMMLMMMRM,O:9:3:E" // rover meets obstacle immediately after wrapping around
  })
  public void mars_rover_stops_when_meeting_an_obstacle(String commands, String expectedState) {
    var marsRoverDriver = new RoverDriver(new Obstacle(0, 3));
    var rover = marsRoverDriver.drive(commands);
    assertThat(rover.getState()).isEqualTo(expectedState);
  }
}
