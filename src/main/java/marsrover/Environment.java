package marsrover;

public class Environment {

    private final int width;
    private final int height;
    private final Obstacle[] obstacles;

    public Environment(int width, int height, Obstacle... obstacles) {
        this.width = width;
        this.height = height;
        this.obstacles = obstacles;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Obstacle[] getObstacles() {
        return obstacles;
    }
}
