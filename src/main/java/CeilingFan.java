public class CeilingFan extends Fan{

    public CeilingFan(int speed, Direction direction) {
        super(speed,direction);
    }

    /**
     * Method to increase the speed when cord one is pulled.
     * The direction remains unchanged.
     */
    public void increaseSpeed(){
        this.speed = this.speed + 1;
        if(this.speed > MAX_SPEED)
            this.speed = 0; //Fan is at speed 0 (OFF)
    }

    /**
     * Method to reverse the direction when cord two is pulled.
     * The speed remains unchanged.
     */
    public void reverseDirection() {
        switch (this.direction) {
            case CLOCKWISE -> this.direction = Direction.ANTI_CLOCKWISE;
            case ANTI_CLOCKWISE -> this.direction = Direction.CLOCKWISE;
        }
    }
}
