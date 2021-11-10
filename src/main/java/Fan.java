public class Fan {
    protected static int MIN_SPEED = 0;
    protected static int MAX_SPEED = 3;

    protected int speed;
    protected Direction direction;

    public Fan(int speed, Direction direction) {
        this.speed = speed;
        this.direction = direction;
    }

    public static int getMinSpeed() {
        return MIN_SPEED;
    }

    public static void setMinSpeed(int minSpeed) {
        MIN_SPEED = minSpeed;
    }

    public static int getMaxSpeed() {
        return MAX_SPEED;
    }

    public static void setMaxSpeed(int maxSpeed) {
        MAX_SPEED = maxSpeed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if(speed >= MIN_SPEED && speed <= MAX_SPEED)
            this.speed = speed;
        else
            throw new IllegalArgumentException("Speed can only be between "+ MIN_SPEED +" & " + MAX_SPEED);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
