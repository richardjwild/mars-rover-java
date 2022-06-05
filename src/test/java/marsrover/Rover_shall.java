package marsrover;

import net.jqwik.api.*;

import static java.lang.String.format;
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
                var expectedState = format("%d:%d:%s", x, y, EAST.getAbbreviation());
                return rover.perform(RIGHT).getState().equals(expectedState);
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
                var expectedState = format("%d:%d:%s", x, y, WEST.getAbbreviation());
                return rover.perform(LEFT).getState().equals(expectedState);
            }
        }

        @Group
        class when_moving_forward {

            @Property
            boolean increment_its_y_position_with_direction_unchanged(
                    @ForAll("x positions") int x,
                    @ForAll("y positions except north edge") int y)
            {
                var rover = new Rover(NORTH, new Vector(x, y), WORLD);
                var expectedState = format("%d:%d:%s", x, y + 1, NORTH.getAbbreviation());
                return rover.perform(MOVE).getState().equals(expectedState);
            }

            @Property
            boolean wrap_over_northern_edge_of_grid(@ForAll("x positions") int x) {
                var rover = new Rover(NORTH, new Vector(x, HEIGHT - 1), WORLD);
                var expectedState = format("%d:%d:%s", x, 0, NORTH.getAbbreviation());
                return rover.perform(MOVE).getState().equals(expectedState);
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
                var expectedState = format("%d:%d:%s", x, y, SOUTH.getAbbreviation());
                return rover.perform(RIGHT).getState().equals(expectedState);
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
                var expectedState = format("%d:%d:%s", x, y, NORTH.getAbbreviation());
                return rover.perform(LEFT).getState().equals(expectedState);
            }
        }

        @Group
        class when_moving_forward {

            @Property
            boolean increment_its_x_position_with_direction_unchanged(
                    @ForAll("x positions except east edge") int x,
                    @ForAll("y positions") int y)
            {
                var rover = new Rover(EAST, new Vector(x, y), WORLD);
                var expectedState = format("%d:%d:%s", x + 1, y, EAST.getAbbreviation());
                return rover.perform(MOVE).getState().equals(expectedState);
            }

            @Property
            boolean wrap_over_eastern_edge_of_grid(@ForAll("y positions") int y) {
                var rover = new Rover(EAST, new Vector(WIDTH - 1, y), WORLD);
                var expectedState = format("%d:%d:%s", 0, y, EAST.getAbbreviation());
                return rover.perform(MOVE).getState().equals(expectedState);
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
                var expectedState = format("%d:%d:%s", x, y, WEST.getAbbreviation());
                return rover.perform(RIGHT).getState().equals(expectedState);
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
                var expectedState = format("%d:%d:%s", x, y, EAST.getAbbreviation());
                return rover.perform(LEFT).getState().equals(expectedState);
            }
        }

        @Group
        class when_moving_forward {

            @Property
            boolean decrement_its_y_position_with_direction_unchanged(
                    @ForAll("x positions") int x,
                    @ForAll("y positions except south edge") int y)
            {
                var rover = new Rover(SOUTH, new Vector(x, y), WORLD);
                var expectedState = format("%d:%d:%s", x, y - 1, SOUTH.getAbbreviation());
                return rover.perform(MOVE).getState().equals(expectedState);
            }

            @Property
            boolean wrap_over_southern_edge_of_grid(@ForAll("x positions") int x) {
                var rover = new Rover(SOUTH, new Vector(x, 0), WORLD);
                var expectedState = format("%d:%d:%s", x, HEIGHT - 1, SOUTH.getAbbreviation());
                return rover.perform(MOVE).getState().equals(expectedState);
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
                var expectedState = format("%d:%d:%s", x, y, NORTH.getAbbreviation());
                return rover.perform(RIGHT).getState().equals(expectedState);
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
                var expectedState = format("%d:%d:%s", x, y, SOUTH.getAbbreviation());
                return rover.perform(LEFT).getState().equals(expectedState);
            }
        }

        @Group
        class when_moving_forward {

            @Property
            boolean decrement_its_x_position_with_direction_unchanged(
                    @ForAll("x positions except west edge") int x,
                    @ForAll("y positions") int y)
            {
                var rover = new Rover(WEST, new Vector(x, y), WORLD);
                var expectedState = format("%d:%d:%s", x - 1, y, WEST.getAbbreviation());
                return rover.perform(MOVE).getState().equals(expectedState);
            }

            @Property
            boolean wrap_over_western_edge_of_grid(@ForAll("y positions") int y) {
                var rover = new Rover(WEST, new Vector(0, y), WORLD);
                var expectedState = format("%d:%d:%s", WIDTH - 1, y, WEST.getAbbreviation());
                return rover.perform(MOVE).getState().equals(expectedState);
            }
        }
    }

    @Provide("x positions")
    Arbitrary<Integer> xPositions() {
        return Arbitraries.integers().between(0, WIDTH - 1);
    }

    @Provide("x positions except east edge")
    Arbitrary<Integer> xPositionsExceptEastEdge() {
        return Arbitraries.integers().between(0, WIDTH - 2);
    }

    @Provide("x positions except west edge")
    Arbitrary<Integer> xPositionsExceptWestEdge() {
        return Arbitraries.integers().between(1, WIDTH - 1);
    }

    @Provide("y positions")
    Arbitrary<Integer> yPositions() {
        return Arbitraries.integers().between(0, HEIGHT - 1);
    }

    @Provide("y positions except north edge")
    Arbitrary<Integer> yPositionsExceptNorthEdge() {
        return Arbitraries.integers().between(0, HEIGHT - 2);
    }

    @Provide("y positions except south edge")
    Arbitrary<Integer> yPositionsExceptSouthEdge() {
        return Arbitraries.integers().between(1, HEIGHT - 1);
    }

}
