package marsrover;

import static java.lang.String.format;

public abstract class Rover {

  protected final int x;
  protected final int y;
  protected final Environment environment;

  protected Rover(int x, int y, Environment environment) {
    this.environment = environment;
    this.x = wrap(x, environment.getWidth());
    this.y = wrap(y, environment.getHeight());
  }

  private int wrap(int value, int size) {
    if (value < 0)
      return value + size;
    else if (value >= size)
      return value - size;
    else
      return value;
  }

  public String getState() {
    return format("%d:%d:%s", x, y, getDirectionCode());
  }

  public abstract Rover turnLeft();

  public abstract Rover turnRight();

  public abstract Rover move();

  protected abstract String getDirectionCode();
}
