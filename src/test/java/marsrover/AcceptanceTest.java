package marsrover;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class AcceptanceTest {

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

  @Test
  public void mars_rover_stops_when_meeting_an_obstacle() {
    var marsRoverDriver = new RoverDriver(new Obstacle(0, 3));
    var rover = marsRoverDriver.drive("MMMM");
    assertThat(rover.getState()).isEqualTo("O:0:2:N");
  }
}
