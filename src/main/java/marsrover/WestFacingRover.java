package marsrover;

public class WestFacingRover extends Rover {

    public WestFacingRover(int x, int y) {
        super(x, y);
    }

    @Override
    public Rover turnLeft() {
        return new SouthFacingRover(x, y);
    }

    @Override
    public Rover turnRight() {
        return new NorthFacingRover(x, y);
    }

    @Override
    public Rover move() {
        return new WestFacingRover(x - 1, y);
    }

    @Override
    protected String getDirectionCode() {
        return "W";
    }
}
