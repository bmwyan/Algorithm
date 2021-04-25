package week04;

import org.junit.Test;

import static org.junit.Assert.*;

public class LargestIslandTest {
    LargestIsland l = new LargestIsland();

    @Test
    public void largestIsland() {
        assertEquals(2, l.largestIsland(new int[][]{new int[]{0, 0}, new int[]{0, 1}}));
    }
}