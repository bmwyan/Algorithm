package week01;

import org.junit.Test;

import static org.junit.Assert.*;

public class RotateArrayTest {
    RotateArray r = new RotateArray();

    @Test
    public void rotate() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        r.rotate(nums, 1);
        assertArrayEquals(new int[]{6,1,2, 3, 4, 5}, nums);
    }

    @Test
    public void rotate2() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6,7};
        r.rotate(nums, 3);
        assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3,4}, nums);
    }
}