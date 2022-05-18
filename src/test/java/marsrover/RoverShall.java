package marsrover;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RoverShall {

    @Nested
    class WhenFacingNorth {

        Rover rover = new NorthFacingRover(1, 1);

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
    }

    @Nested
    class WhenFacingEast {

        Rover rover = new EastFacingRover(1, 1);

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
    }

    @Nested
    class WhenFacingSouth {

        Rover rover = new SouthFacingRover(1, 1);

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
    }

    @Nested
    class WhenFacingWest {

        Rover rover = new WestFacingRover(1, 1);

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
    }
}
