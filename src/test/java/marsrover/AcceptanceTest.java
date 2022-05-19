package marsrover;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AcceptanceTest {

  @Test
  void mars_rover_drives_around() {
    var environment = new Environment(10, 10);
    var marsRoverDriver = new MarsRoverDriver(environment);
    var rover = marsRoverDriver.drive("MMRMMLM");
    assertThat(rover.getState()).isEqualTo("2:3:N");
  }

  @Test
  void mars_rover_wraps_around_at_edge_of_grid() {
    var environment = new Environment(10, 10);
    var marsRoverDriver = new MarsRoverDriver(environment);
    var rover = marsRoverDriver.drive("MMMMMMMMMM");
    assertThat(rover.getState()).isEqualTo("0:0:N");
  }

  @Test
  @Disabled
  void mars_rover_stops_when_meeting_an_obstacle() {
    var environment = new Environment(10, 10, new Obstacle(0, 3));
    var marsRoverDriver = new MarsRoverDriver(environment);
    var rover = marsRoverDriver.drive("MMMM");
    assertThat(rover.getState()).isEqualTo("O:0:2:N");
  }
}
