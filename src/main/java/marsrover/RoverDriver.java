package marsrover;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static marsrover.Direction.NORTH;

public class RoverDriver {

    private static final Direction INITIAL_DIRECTION = NORTH;
    private static final Vector INITIAL_POSITION = new Vector(0, 0);

    private final Grid world;

    public RoverDriver(Obstacle... obstacles) {
        world = new Grid(10, 10, stream(obstacles).collect(toList()));
    }

    public Rover drive(String commands) {
        var rover = new Rover(INITIAL_DIRECTION, INITIAL_POSITION, world);
        for (var c : commands.toCharArray()) {
            rover = rover.perform(Command.from(c));
        }
        return rover;
    }
}
