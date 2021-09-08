package marsrover;

public enum Direction {

  NORTH("N"), EAST("E"), SOUTH("S"), WEST("W");

  private String abbreviation;

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

  public Direction turnRight() {
    switch (this) {
      case NORTH:
        return EAST;
      case EAST:
        return SOUTH;
      case SOUTH:
        return WEST;
      default:
        return NORTH;
    }
  }

  public Vector getTranslation() {
    switch (this) {
      case NORTH:
        return new Vector(0, 1);
      default:
        return new Vector(1, 0);
    }
  }

  Direction(String abbreviation) {
    this.abbreviation = abbreviation;
  }

  public String getAbbreviation() {
    return abbreviation;
  }
}
