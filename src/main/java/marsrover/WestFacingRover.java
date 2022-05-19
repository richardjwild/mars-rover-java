package marsrover;

public class WestFacingRover extends Rover {

    public WestFacingRover(int x, int y, Environment environment) {
        super(x, y, environment);
    }

    @Override
    public Rover turnLeft() {
        return new SouthFacingRover(x, y, environment);
    }

    @Override
    public Rover turnRight() {
        return new NorthFacingRover(x, y, environment);
    }

    @Override
    public Rover move() {
        return new WestFacingRover(x - 1, y, environment);
    }

    @Override
    protected String getDirectionCode() {
        return "W";
    }
}
