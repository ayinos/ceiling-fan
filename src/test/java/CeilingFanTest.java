import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CeilingFanTest {

    /**
     * Test that speed increases by one and direction is unchanged.
     */
    @Test
    public void testSpeedIncrease() {
        CeilingFan fan = new CeilingFan(0,Direction.CLOCKWISE);
        fan.increaseSpeed();

        assertEquals(1, fan.getSpeed());
        assertEquals(Direction.CLOCKWISE, fan.getDirection());
    }

    /**
     * Test cycling through all the speed limits.
     */
    @Test
    public void testSpeedCycleThrough() {
        CeilingFan fan = new CeilingFan(0,Direction.CLOCKWISE);
        fan.increaseSpeed(); //Speed is 1
        fan.increaseSpeed(); //Speed is 2
        fan.increaseSpeed(); //Speed is 3
        fan.increaseSpeed(); //Speed is 0

        assertEquals(0, fan.getSpeed());
        assertEquals(Direction.CLOCKWISE, fan.getDirection());
    }

    /**
     * Test that fan stops if speed is 3 and speed is increased (i.e. cord one is pulled)
     */
    @Test
    public void testFanStop() {
        CeilingFan fan = new CeilingFan(3,Direction.CLOCKWISE);
        fan.increaseSpeed();

        assertEquals(0, fan.getSpeed());
        assertEquals(Direction.CLOCKWISE, fan.getDirection());
    }

    /**
     * Test exception if invalid speed is set.
     */
    @Test
    public void testInvalidSpeed() {
        CeilingFan fan = new CeilingFan(0,Direction.CLOCKWISE);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> fan.setSpeed(200));

        String expectedMessage = "Speed can only be between";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    /**
     * Test that max speed limit can be changed.
     */
    @Test
    public void testMaxSpeedLimitChange() {
        CeilingFan.setMaxSpeed(2);
        CeilingFan fan = new CeilingFan(2,Direction.CLOCKWISE);
        fan.increaseSpeed();

        assertEquals(0, fan.getSpeed());
        assertEquals(Direction.CLOCKWISE, fan.getDirection());
    }

    /**
     * Test that clockwise direction is reversed and speed is unchanged.
     */
    @Test
    public void testReverseDirectionClockwise() {
        CeilingFan fan = new CeilingFan(3,Direction.CLOCKWISE);
        fan.reverseDirection();

        assertEquals(3, fan.getSpeed());
        assertEquals(Direction.ANTI_CLOCKWISE, fan.getDirection());
    }


    /**
     * Test that anti-clockwise direction is reversed and speed is unchanged.
     */
    @Test
    public void testReverseDirectionAntiClockwise() {
        CeilingFan fan = new CeilingFan(2,Direction.ANTI_CLOCKWISE);
        fan.reverseDirection();

        assertEquals(2, fan.getSpeed());
        assertEquals(Direction.CLOCKWISE, fan.getDirection());
    }

}