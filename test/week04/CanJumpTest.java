package week04;

import org.junit.Test;

import static org.junit.Assert.*;

public class CanJumpTest {
    CanJump can = new CanJump();

    @Test
    public void canJump() {
        assertEquals(true, can.canJump(new int[]{2, 3, 1, 1, 4}));
    }
}