package week12;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumDecodingsTest {
    NumDecodings num = new NumDecodings();

    @Test
    public void numDecodings() {
        assertEquals(2,num.numDecodings("12"));
    }

    @Test
    public void numDecodings2() {
        assertEquals(3,num.numDecodings("226"));
    }
}