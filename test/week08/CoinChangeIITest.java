package week08;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoinChangeIITest {

    CoinChangeII coin = new CoinChangeII();

    @Test
    public void change() {
        assertEquals(4,coin.change(5,new int[]{1,2,5}));
    }
}