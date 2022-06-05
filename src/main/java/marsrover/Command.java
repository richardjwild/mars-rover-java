package marsrover;

public enum Command {
    RIGHT, MOVE, LEFT;

    public static Command from(char c) {
        switch (c) {
            case 'L':
                return LEFT;
            case 'R':
                return RIGHT;
            case 'M':
                return MOVE;
            default:
                throw new IllegalArgumentException();
        }
    }
}
