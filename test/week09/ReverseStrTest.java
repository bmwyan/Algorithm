package week09;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseStrTest {
    ReverseStr r = new ReverseStr();


    @Test
    public void reverseStr() {
        assertEquals("bacdfeg",r.reverseStr("abcdefg",2));
    }
}