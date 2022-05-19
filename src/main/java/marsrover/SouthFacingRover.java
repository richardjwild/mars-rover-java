package marsrover;

public class SouthFacingRover extends Rover {

    public SouthFacingRover(int x, int y, Environment environment) {
        super(x, y, environment);
    }

    @Override
    public Rover turnLeft() {
        return new EastFacingRover(x, y, environment);
    }

    @Override
    public Rover turnRight() {
        return new WestFacingRover(x, y, environment);
    }

    @Override
    public Rover move() {
        return new SouthFacingRover(x, y - 1, environment);
    }

    @Override
    protected String getDirectionCode() {
        return "S";
    }
}
