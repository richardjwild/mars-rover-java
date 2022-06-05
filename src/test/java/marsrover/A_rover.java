package marsrover;

import net.jqwik.api.*;

import static marsrover.Command.*;
import static marsrover.Direction.*;

class A_rover {

    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;
    private static final Grid WORLD = new Grid(WIDTH, HEIGHT);

    @Group
    class when_facing_north {

        private Rover rover(int x, int y) {
            return new Rover(NORTH, new Vector(x, y), WORLD);
        }

        @Group
        class on_turning_right {

            @Property
            boolean faces_east_with_position_unchanged(@ForAll("x positions") int x, @ForAll("y positions") int y) {
                return rover(x, y).perform(RIGHT).getState().equals(expectedState(x, y, EAST));
            }
        }

        @Group
        class on_turning_left {

            @Property
            boolean faces_west_with_position_unchanged(@ForAll("x positions") int x, @ForAll("y positions") int y) {
                return rover(x, y).perform(LEFT).getState().equals(expectedState(x, y, WEST));
            }
        }

        @Group
        class on_moving_forward {

            @Property
            boolean moves_north_with_direction_unchanged(
                    @ForAll("x positions") int x,
                    @ForAll("y positions except northern edge") int y)
            {
                return rover(x, y).perform(MOVE).getState().equals(expectedState(x, y + 1, NORTH));
            }

            @Property
            boolean wraps_over_northern_edge_of_grid(@ForAll("x positions") int x) {
                return rover(x, HEIGHT - 1).perform(MOVE).getState().equals(expectedState(x, 0, NORTH));
            }
        }
    }

    @Group
    class when_facing_east {

        private Rover rover(int x, int y) {
            return new Rover(EAST, new Vector(x, y), WORLD);
        }

        @Group
        class on_turning_right {

            @Property
            boolean faces_south_with_position_unchanged(@ForAll("x positions") int x, @ForAll("y positions") int y) {
                return rover(x, y).perform(RIGHT).getState().equals(expectedState(x, y, SOUTH));
            }
        }

        @Group
        class on_turning_left {

            @Property
            boolean faces_north_with_position_unchanged(@ForAll("x positions") int x, @ForAll("y positions") int y) {
                return rover(x, y).perform(LEFT).getState().equals(expectedState(x, y, NORTH));
            }
        }

        @Group
        class on_moving_forward {

            @Property
            boolean moves_east_with_direction_unchanged(
                    @ForAll("x positions except eastern edge") int x,
                    @ForAll("y positions") int y)
            {
                return rover(x, y).perform(MOVE).getState().equals(expectedState(x + 1, y, EAST));
            }

            @Property
            boolean wraps_over_eastern_edge_of_grid(@ForAll("y positions") int y) {
                return rover(WIDTH - 1, y).perform(MOVE).getState().equals(expectedState(0, y, EAST));
            }
        }
    }

    @Group
    class when_facing_south {

        private Rover rover(int x, int y) {
            return new Rover(SOUTH, new Vector(x, y), WORLD);
        }

        @Group
        class on_turning_right {

            @Property
            boolean faces_west_with_position_unchanged(@ForAll("x positions") int x, @ForAll("y positions") int y) {
                return rover(x, y).perform(RIGHT).getState().equals(expectedState(x, y, WEST));
            }
        }

        @Group
        class on_turning_left {

            @Property
            boolean faces_east_with_position_unchanged(@ForAll("x positions") int x, @ForAll("y positions") int y) {
                return rover(x, y).perform(LEFT).getState().equals(expectedState(x, y, EAST));
            }
        }

        @Group
        class on_moving_forward {

            @Property
            boolean moves_south_with_direction_unchanged(
                    @ForAll("x positions") int x,
                    @ForAll("y positions except southern edge") int y)
            {
                return rover(x, y).perform(MOVE).getState().equals(expectedState(x, y - 1, SOUTH));
            }

            @Property
            boolean wraps_over_southern_edge_of_grid(@ForAll("x positions") int x) {
                return rover(x, 0).perform(MOVE).getState().equals(expectedState(x, HEIGHT - 1, SOUTH));
            }
        }
    }

    @Group
    class when_facing_west {

        private Rover rover(int x, int y) {
            return new Rover(WEST, new Vector(x, y), WORLD);
        }

        @Group
        class on_turning_right {

            @Property
            boolean faces_north_with_position_unchanged(@ForAll("x positions") int x, @ForAll("y positions") int y) {
                return rover(x, y).perform(RIGHT).getState().equals(expectedState(x, y, NORTH));
            }
        }

        @Group
        class on_turning_left {

            @Property
            boolean faces_south_with_position_unchanged(@ForAll("x positions") int x, @ForAll("y positions") int y) {
                return rover(x, y).perform(LEFT).getState().equals(expectedState(x, y, SOUTH));
            }
        }

        @Group
        class on_moving_forward {

            @Property
            boolean moves_west_with_direction_unchanged(
                    @ForAll("x positions except western edge") int x,
                    @ForAll("y positions") int y)
            {
                return rover(x, y).perform(MOVE).getState().equals(expectedState(x - 1, y, WEST));
            }

            @Property
            boolean wraps_over_western_edge_of_grid(@ForAll("y positions") int y) {
                return rover(0, y).perform(MOVE).getState().equals(expectedState(WIDTH - 1, y, WEST));
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
