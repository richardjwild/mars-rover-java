package marsrover;

import net.jqwik.api.*;

import static marsrover.Command.*;
import static marsrover.Direction.*;

@Group
class Rover_shall {

    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;
    private static final Grid WORLD = new Grid(WIDTH, HEIGHT);

    @Group
    class given_facing_north {

        @Group
        class when_turning_right {

            @Property
            boolean face_east_with_position_unchanged(
                    @ForAll("x positions") int x,
                    @ForAll("y positions") int y)
            {
                var rover = new Rover(NORTH, new Vector(x, y), WORLD);
                return rover.perform(RIGHT).getState().equals(expectedState(x, y, EAST));
            }
        }

        @Group
        class when_turning_left {

            @Property
            boolean face_west_with_position_unchanged(
                    @ForAll("x positions") int x,
                    @ForAll("y positions") int y)
            {
                var rover = new Rover(NORTH, new Vector(x, y), WORLD);
                return rover.perform(LEFT).getState().equals(expectedState(x, y, WEST));
            }
        }

        @Group
        class when_moving_forward {

            @Property
            boolean increment_its_y_position_with_direction_unchanged(
                    @ForAll("x positions") int x,
                    @ForAll("y positions except northern edge") int y)
            {
                var rover = new Rover(NORTH, new Vector(x, y), WORLD);
                return rover.perform(MOVE).getState().equals(expectedState(x, y + 1, NORTH));
            }

            @Property
            boolean wrap_over_northern_edge_of_grid(@ForAll("x positions") int x) {
                var rover = new Rover(NORTH, new Vector(x, HEIGHT - 1), WORLD);
                return rover.perform(MOVE).getState().equals(expectedState(x, 0, NORTH));
            }
        }
    }

    @Group
    class given_facing_east {

        @Group
        class when_turning_right {

            @Property
            boolean face_south_with_position_unchanged(
                    @ForAll("x positions") int x,
                    @ForAll("y positions") int y)
            {
                var rover = new Rover(EAST, new Vector(x, y), WORLD);
                return rover.perform(RIGHT).getState().equals(expectedState(x, y, SOUTH));
            }
        }

        @Group
        class when_turning_left {

            @Property
            boolean face_north_with_position_unchanged(
                    @ForAll("x positions") int x,
                    @ForAll("y positions") int y)
            {
                var rover = new Rover(EAST, new Vector(x, y), WORLD);
                return rover.perform(LEFT).getState().equals(expectedState(x, y, NORTH));
            }
        }

        @Group
        class when_moving_forward {

            @Property
            boolean increment_its_x_position_with_direction_unchanged(
                    @ForAll("x positions except eastern edge") int x,
                    @ForAll("y positions") int y)
            {
                var rover = new Rover(EAST, new Vector(x, y), WORLD);
                return rover.perform(MOVE).getState().equals(expectedState(x + 1, y, EAST));
            }

            @Property
            boolean wrap_over_eastern_edge_of_grid(@ForAll("y positions") int y) {
                var rover = new Rover(EAST, new Vector(WIDTH - 1, y), WORLD);
                return rover.perform(MOVE).getState().equals(expectedState(0, y, EAST));
            }
        }
    }

    @Group
    class given_facing_south {

        @Group
        class when_turning_right {

            @Property
            boolean face_west_with_position_unchanged(
                    @ForAll("x positions") int x,
                    @ForAll("y positions") int y)
            {
                var rover = new Rover(SOUTH, new Vector(x, y), WORLD);
                return rover.perform(RIGHT).getState().equals(expectedState(x, y, WEST));
            }
        }

        @Group
        class when_turning_left {

            @Property
            boolean face_east_with_position_unchanged(
                    @ForAll("x positions") int x,
                    @ForAll("y positions") int y)
            {
                var rover = new Rover(SOUTH, new Vector(x, y), WORLD);
                return rover.perform(LEFT).getState().equals(expectedState(x, y, EAST));
            }
        }

        @Group
        class when_moving_forward {

            @Property
            boolean decrement_its_y_position_with_direction_unchanged(
                    @ForAll("x positions") int x,
                    @ForAll("y positions except southern edge") int y)
            {
                var rover = new Rover(SOUTH, new Vector(x, y), WORLD);
                return rover.perform(MOVE).getState().equals(expectedState(x, y - 1, SOUTH));
            }

            @Property
            boolean wrap_over_southern_edge_of_grid(@ForAll("x positions") int x) {
                var rover = new Rover(SOUTH, new Vector(x, 0), WORLD);
                return rover.perform(MOVE).getState().equals(expectedState(x, HEIGHT - 1, SOUTH));
            }
        }
    }

    @Group
    class given_facing_west {

        @Group
        class when_turning_right {

            @Property
            boolean face_north_with_position_unchanged(
                    @ForAll("x positions") int x,
                    @ForAll("y positions") int y)
            {
                var rover = new Rover(WEST, new Vector(x, y), WORLD);
                return rover.perform(RIGHT).getState().equals(expectedState(x, y, NORTH));
            }
        }

        @Group
        class when_turning_left {

            @Property
            boolean face_south_with_position_unchanged(
                    @ForAll("x positions") int x,
                    @ForAll("y positions") int y)
            {
                var rover = new Rover(WEST, new Vector(x, y), WORLD);
                return rover.perform(LEFT).getState().equals(expectedState(x, y, SOUTH));
            }
        }

        @Group
        class when_moving_forward {

            @Property
            boolean decrement_its_x_position_with_direction_unchanged(
                    @ForAll("x positions except western edge") int x,
                    @ForAll("y positions") int y)
            {
                var rover = new Rover(WEST, new Vector(x, y), WORLD);
                return rover.perform(MOVE).getState().equals(expectedState(x - 1, y, WEST));
            }

            @Property
            boolean wrap_over_western_edge_of_grid(@ForAll("y positions") int y) {
                var rover = new Rover(WEST, new Vector(0, y), WORLD);
                return rover.perform(MOVE).getState().equals(expectedState(WIDTH - 1, y, WEST));
            }
        }
    }

    private String expectedState(int x, int y, Direction direction) {
        return String.format("%d:%d:%s", x, y, direction.getAbbreviation());
    }

    @Provide("x positions")
    Arbitrary<Integer> xPositions() {
        return Arbitraries.integers().between(0, WIDTH - 1);
    }

    @Provide("x positions except eastern edge")
    Arbitrary<Integer> xPositionsExceptEasternEdge() {
        return Arbitraries.integers().between(0, WIDTH - 2);
    }

    @Provide("x positions except western edge")
    Arbitrary<Integer> xPositionsExceptWesternEdge() {
        return Arbitraries.integers().between(1, WIDTH - 1);
    }

    @Provide("y positions")
    Arbitrary<Integer> yPositions() {
        return Arbitraries.integers().between(0, HEIGHT - 1);
    }

    @Provide("y positions except northern edge")
    Arbitrary<Integer> yPositionsExceptNorthernEdge() {
        return Arbitraries.integers().between(0, HEIGHT - 2);
    }

    @Provide("y positions except southern edge")
    Arbitrary<Integer> yPositionsExceptSouthernEdge() {
        return Arbitraries.integers().between(1, HEIGHT - 1);
    }

}
