package week06;

import org.junit.Test;

import static org.junit.Assert.*;

public class StockMaxProfitCoolDownTest {
    StockMaxProfitCoolDown s= new StockMaxProfitCoolDown();

    @Test
    public void maxProfit() {
        assertEquals(3,s.maxProfit(new int[]{1,2,3,0,2}));
    }
}