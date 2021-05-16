package week06;

import org.junit.Test;

import static org.junit.Assert.*;

public class StockMaxProfitIVTest {
    StockMaxProfitIV s = new StockMaxProfitIV();

    @Test
    public void maxProfit() {
        assertEquals(2, s.maxProfit(2, new int[]{2, 4, 1}));
    }
}