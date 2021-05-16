package week06;

import org.junit.Test;

import static org.junit.Assert.*;

public class StockMaxProfitTest {
    StockMaxProfit s = new StockMaxProfit();

    @Test
    public void maxProfit() {
        assertEquals(5,s.maxProfit(new int[]{7,1,5,3,6,4}));
    }
}