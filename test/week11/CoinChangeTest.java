package week11;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoinChangeTest {
    CoinChange c = new CoinChange();

    //CoinChangeDFS c= new CoinChangeDFS();

    @Test
    public void coinChange() {

        assertEquals(3, c.coinChange(new int[]{1, 2, 5}, 11));
    }

    @Test
    public void coinChange1() {

        assertEquals(-1, c.coinChange(new int[]{2}, 3));
    }

    @Test
    public void coinChange2() {
        assertEquals(-1, c.coinChange(new int[]{2}, 3));
    }


    @Test
    public void coinChange3() {
        assertEquals(0, c.coinChange(new int[]{1}, 0));
    }

    @Test
    public void coinChange4() {
        assertEquals(1, c.coinChange(new int[]{1}, 1));
    }

    @Test
    public void coinChange5() {
        assertEquals(2, c.coinChange(new int[]{1}, 2));
    }

    @Test
    public void coinChange6() {
        assertEquals(35, c.coinChange(new int[]{357, 239, 73, 52}, 9832));
    }

    @Test
    public void coinChange7() {
        assertEquals(24, c.coinChange(new int[]{411,412,413,414,415,416,417,418,419,420,421,422}, 9864));
    }

    @Test
    public void coinChange8() {
        assertEquals(25, c.coinChange(new int[]{3,7,405,436}, 8839));
    }


}