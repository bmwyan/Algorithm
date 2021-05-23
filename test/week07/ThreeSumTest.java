package week07;

import org.junit.Test;

import static org.junit.Assert.*;

public class ThreeSumTest {
    ThreeSum t = new ThreeSum();

    @Test
    public void threeSum() {
        t.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
}