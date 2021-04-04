package week01;

import org.junit.Test;

import static org.junit.Assert.*;

public class ThreeSumTest {
    ThreeSum three = new ThreeSum();

    @Test
    public void threeSum() {
        three.threeSum(new int[]{-1,0,1,2,-1,-4});
    }
}