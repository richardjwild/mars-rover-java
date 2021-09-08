package marsrover;

public enum Direction {

  NORTH, EAST, SOUTH, WEST;

  public Direction turnLeft() {
    switch (this) {
      case NORTH:
        return WEST;
      case WEST:
        return SOUTH;
      case SOUTH:
        return EAST;
      default:
        return NORTH;
    }
  }

}
