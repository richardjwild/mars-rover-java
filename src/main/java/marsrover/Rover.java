package marsrover;

import static java.lang.String.format;

public abstract class Rover {

  protected final int x;
  protected final int y;

  protected Rover(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public String getState() {
    return format("%d:%d:%s", x, y, getDirectionCode());
  }

  public abstract Rover turnLeft();

  public abstract Rover turnRight();

  public abstract Rover move();

  protected abstract String getDirectionCode();
}
