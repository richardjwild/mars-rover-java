package marsrover;

public class EastFacingRover extends Rover {

    public EastFacingRover(int x, int y) {
        super(x, y);
    }

    @Override
    public Rover turnLeft() {
        return new NorthFacingRover(x, y);
    }

    @Override
    public Rover turnRight() {
        return new SouthFacingRover(x, y);
    }

    @Override
    public Rover move() {
        return new EastFacingRover(x + 1, y);
    }

    @Override
    protected String getDirectionCode() {
        return "E";
    }
}
