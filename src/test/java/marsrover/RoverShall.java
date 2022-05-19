package marsrover;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RoverShall {

    Environment environment = new Environment(10, 10);

    @Nested
    class WhenFacingNorth {

        Rover rover = new NorthFacingRover(1, 1, environment);

        @Test
        void move_northwards() {
            assertThat(rover.move().getState()).isEqualTo("1:2:N");
        }

        @Test
        void face_west_on_turning_left() {
            assertThat(rover.turnLeft().getState()).isEqualTo("1:1:W");
        }

        @Test
        void face_east_on_turning_right() {
            assertThat(rover.turnRight().getState()).isEqualTo("1:1:E");
        }

        @Test
        void wrap_over_north_edge_of_grid() {
            var rover = new NorthFacingRover(0, 9, environment);
            assertThat(rover.move().getState()).isEqualTo("0:0:N");
        }
    }

    @Nested
    class WhenFacingEast {

        Rover rover = new EastFacingRover(1, 1, environment);

        @Test
        void move_eastwards() {
            assertThat(rover.move().getState()).isEqualTo("2:1:E");
        }

        @Test
        void face_north_on_turning_left() {
            assertThat(rover.turnLeft().getState()).isEqualTo("1:1:N");
        }

        @Test
        void face_south_on_turning_right() {
            assertThat(rover.turnRight().getState()).isEqualTo("1:1:S");
        }

        @Test
        void wrap_over_east_edge_of_grid() {
            var rover = new EastFacingRover(9, 0, environment);
            assertThat(rover.move().getState()).isEqualTo("0:0:E");
        }
    }

    @Nested
    class WhenFacingSouth {

        Rover rover = new SouthFacingRover(1, 1, environment);

        @Test
        void move_southwards() {
            assertThat(rover.move().getState()).isEqualTo("1:0:S");
        }

        @Test
        void face_east_on_turning_left() {
            assertThat(rover.turnLeft().getState()).isEqualTo("1:1:E");
        }

        @Test
        void face_west_on_turning_right() {
            assertThat(rover.turnRight().getState()).isEqualTo("1:1:W");
        }

        @Test
        void wrap_over_south_edge_of_grid() {
            var rover = new SouthFacingRover(0, 0, environment);
            assertThat(rover.move().getState()).isEqualTo("0:9:S");
        }
    }

    @Nested
    class WhenFacingWest {

        Rover rover = new WestFacingRover(1, 1, environment);

        @Test
        void move_southwards() {
            assertThat(rover.move().getState()).isEqualTo("0:1:W");
        }

        @Test
        void face_south_on_turning_left() {
            assertThat(rover.turnLeft().getState()).isEqualTo("1:1:S");
        }

        @Test
        void face_north_on_turning_right() {
            assertThat(rover.turnRight().getState()).isEqualTo("1:1:N");
        }

        @Test
        void wrap_over_west_edge_of_grid() {
            var rover = new WestFacingRover(0, 0, environment);
            assertThat(rover.move().getState()).isEqualTo("9:0:W");
        }
    }
}
