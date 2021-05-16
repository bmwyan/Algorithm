package week06;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxProductTest {
    MaxProduct m = new MaxProduct();

    @Test
    public void maxProduct() {
        assertEquals(24, m.maxProduct(new int[]{-2, 3, -4}));
    }

    @Test
    public void maxProduct2() {
        assertEquals(1, m.maxProduct(new int[]{2, -1, 1,1}));
    }
}