package week02;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxSlidingWindowTest {
    MaxSlidingWindow max = new MaxSlidingWindow();

    @Test
    public void maxSlidingWindow() {
        assertArrayEquals(new int[]{3, 3, 5, 5, 6,7}, max.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
    }


    @Test
    public void maxSlidingWindow2() {
        assertArrayEquals(new int[]{11}, max.maxSlidingWindow(new int[]{4,3,11}, 3));
    }
}