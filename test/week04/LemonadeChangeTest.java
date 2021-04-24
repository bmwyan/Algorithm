package week04;

import org.junit.Test;

import static org.junit.Assert.*;

public class LemonadeChangeTest {
    LemonadeChange lemon = new LemonadeChange();

    @Test
    public void lemonadeChange() {
        assertEquals(true, lemon.lemonadeChange(new int[]{5, 5, 5, 10, 20}));
    }

    @Test
    public void lemonadeChange2() {
        assertEquals(true, lemon.lemonadeChange(new int[]{5,5,10,10,20}));
    }


}