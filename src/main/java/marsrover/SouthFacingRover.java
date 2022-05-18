package marsrover;

public class SouthFacingRover extends Rover {

    public SouthFacingRover(int x, int y) {
        super(x, y);
    }

    @Override
    public Rover turnLeft() {
        return new EastFacingRover(x, y);
    }

    @Override
    public Rover turnRight() {
        return new WestFacingRover(x, y);
    }

    @Override
    public Rover move() {
        return new SouthFacingRover(x, y - 1);
    }

    @Override
    protected String getDirectionCode() {
        return "S";
    }
}
