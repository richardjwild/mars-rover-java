package marsrover;

public class NorthFacingRover extends Rover {

    public NorthFacingRover(int x, int y) {
        super(x, y);
    }

    @Override
    public Rover turnLeft() {
        return new WestFacingRover(x, y);
    }

    @Override
    public Rover turnRight() {
        return new EastFacingRover(x, y);
    }

    @Override
    public Rover move() {
        return new NorthFacingRover(x, y + 1);
    }

    @Override
    protected String getDirectionCode() {
        return "N";
    }
}
