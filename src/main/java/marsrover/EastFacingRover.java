package marsrover;

public class EastFacingRover extends Rover {

    public EastFacingRover(int x, int y, Environment environment) {
        super(x, y, environment);
    }

    @Override
    public Rover turnLeft() {
        return new NorthFacingRover(x, y, environment);
    }

    @Override
    public Rover turnRight() {
        return new SouthFacingRover(x, y, environment);
    }

    @Override
    public Rover move() {
        return new EastFacingRover(x + 1, y, environment);
    }

    @Override
    protected String getDirectionCode() {
        return "E";
    }
}
