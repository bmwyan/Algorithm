package week10;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxSlidingWindowTest {
    MaxSlidingWindow win = new MaxSlidingWindow();


    @Test
    public void maxSlidingWindow() {
        win.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }

    @Test
    public void maxSlidingWindow2() {
        win.maxSlidingWindow(new int[]{1, -1}, 1);
    }

    @Test
    public void maxSlidingWindow3() {
        assertArrayEquals(new int[]{7, 4}, win.maxSlidingWindow(new int[]{7, 2, 4}, 2));
    }
}