package marsrover;

public class NorthFacingRover extends Rover {

    public NorthFacingRover(int x, int y, Environment environment) {
        super(x, y, environment);
    }

    @Override
    public Rover turnLeft() {
        return new WestFacingRover(x, y, environment);
    }

    @Override
    public Rover turnRight() {
        return new EastFacingRover(x, y, environment);
    }

    @Override
    public Rover move() {
        return new NorthFacingRover(x, y + 1, environment);
    }

    @Override
    protected String getDirectionCode() {
        return "N";
    }
}
