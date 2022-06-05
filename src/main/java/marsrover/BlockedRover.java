package marsrover;

public class BlockedRover extends Rover {

    public BlockedRover(Direction direction, Vector position, Grid world) {
        super(direction, position, world);
    }

    @Override
    public String getState() {
        return String.format("O:%s", super.getState());
    }
}
