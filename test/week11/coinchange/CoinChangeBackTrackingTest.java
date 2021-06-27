package week11.coinchange;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoinChangeBackTrackingTest {

    CoinChangeBackTracking c = new CoinChangeBackTracking();

    @Test
    public void coinChange() {
        assertEquals(3, c.coinChange(new int[]{5, 3}, 11));
    }
}