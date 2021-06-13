package week09;

import org.junit.Test;

import static org.junit.Assert.*;

public class FrogCrossTest {
    FrogCross f = new FrogCross();

    @Test
    public void canCross() {

        assertEquals(true, f.canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));
    }
}