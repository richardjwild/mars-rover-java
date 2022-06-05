package marsrover;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static marsrover.Command.*;
import static marsrover.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;

class RoverShould {

    private static final Grid GRID_3X3 = new Grid(3, 3);
    private static final Vector MIDDLE_OF_GRID = new Vector(1, 1);

    @ParameterizedTest
    @MethodSource
    void turn_left(Direction initialDirection, String expectedState) {
        var initialRover = new Rover(initialDirection, MIDDLE_OF_GRID, GRID_3X3);
        var newRover = initialRover.perform(LEFT);
        assertThat(newRover.getState()).isEqualTo(expectedState);
    }

    private static Stream<Arguments> turn_left() {
        return Stream.of(
                Arguments.of(NORTH, "1:1:W"),
                Arguments.of(WEST, "1:1:S"),
                Arguments.of(SOUTH, "1:1:E"),
                Arguments.of(EAST, "1:1:N")
        );
    }

    @ParameterizedTest
    @MethodSource()
    void turn_right(Direction initialDirection, String expectedState) {
        var initialRover = new Rover(initialDirection, MIDDLE_OF_GRID, GRID_3X3);
        var newRover = initialRover.perform(RIGHT);
        assertThat(newRover.getState()).isEqualTo(expectedState);
    }

    private static Stream<Arguments> turn_right() {
        return Stream.of(
                Arguments.of(NORTH, "1:1:E"),
                Arguments.of(EAST, "1:1:S"),
                Arguments.of(SOUTH, "1:1:W"),
                Arguments.of(WEST, "1:1:N")
        );
    }

    @ParameterizedTest
    @MethodSource()
    void move(Direction initialDirection, String expectedState) {
        var initialRover = new Rover(initialDirection, MIDDLE_OF_GRID, GRID_3X3);
        var newRover = initialRover.perform(MOVE);
        assertThat(newRover.getState()).isEqualTo(expectedState);
    }

    private static Stream<Arguments> move() {
        return Stream.of(
                Arguments.of(NORTH, "1:2:N"),
                Arguments.of(EAST, "2:1:E"),
                Arguments.of(SOUTH, "1:0:S"),
                Arguments.of(WEST, "0:1:W")
        );
    }

    @ParameterizedTest
    @MethodSource()
    void wrap_when_passing_off_edge_of_the_grid(Direction heading, int x, int y,
                                                String expectedState)
    {
        var initialRover = new Rover(heading, new Vector(x, y), new Grid(2, 2));
        var newRover = initialRover.perform(MOVE);
        assertThat(newRover.getState()).isEqualTo(expectedState);
    }

    private static Stream<Arguments> wrap_when_passing_off_edge_of_the_grid() {
        return Stream.of(
                Arguments.of(NORTH, 0, 1, "0:0:N"),
                Arguments.of(SOUTH, 0, 0, "0:1:S"),
                Arguments.of(WEST, 0, 0, "1:0:W"),
                Arguments.of(EAST, 1, 0, "0:0:E")
        );
    }
}
