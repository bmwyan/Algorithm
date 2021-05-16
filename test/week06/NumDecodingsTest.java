package week06;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumDecodingsTest {
    NumDecodings nu = new NumDecodings();

    @Test
    public void numDecodings() {
        assertEquals(2,nu.numDecodings("12"));
    }

    @Test
    public void numDecodings2() {
        assertEquals(1,nu.numDecodings("10"));
    }

    @Test
    public void numDecodings3() {
        assertEquals(1,nu.numDecodings("2101"));
    }
}