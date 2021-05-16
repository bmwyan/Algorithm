package week06;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoinChangeTest {
    CoinChange c = new CoinChange();

    @Test
    public void coinChange() {
        assertEquals(3, c.coinChange(new int[]{1,2, 5}, 11));
    }
}