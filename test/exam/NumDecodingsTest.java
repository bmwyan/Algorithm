package exam;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumDecodingsTest {
    NumDecodings num = new NumDecodings();

    @Test
    public void numDecodings() {
        assertEquals(2, num.numDecodings("12"));
    }

    @Test
    public void numDecodings2() {
        assertEquals(3, num.numDecodings("226"));
    }

    @Test
    public void numDecodings3() {
        assertEquals(0, num.numDecodings("0"));
    }

    @Test
    public void numDecodings4() {
        assertEquals(0, num.numDecodings("06"));
    }

}