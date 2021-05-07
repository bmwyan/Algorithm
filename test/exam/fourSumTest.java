package exam;

import org.junit.Test;

public class fourSumTest {
    FourSum f = new FourSum();

    @Test
    public void fourSum() {
        f.fourSum(new int[]{1,0,-1,0,-2,2},0);
    }
}