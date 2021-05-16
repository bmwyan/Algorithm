package week06;

import org.junit.Test;

import static org.junit.Assert.*;

public class RobIITest {
    RobII r = new RobII();

    @Test
    public void rob() {

        assertEquals(4, r.rob(new int[]{1, 2, 3, 1}));

    }
}