package week05;

import org.junit.Test;
import week05.binarysearch.Sqrt;

import static org.junit.Assert.*;

public class SqrtTest {
    Sqrt s = new Sqrt();

    @Test
    public void mySqrt() {
        assertEquals(2,s.mySqrt(4));
    }
}