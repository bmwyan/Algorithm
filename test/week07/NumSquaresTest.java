package week07;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumSquaresTest {
    NumSquares n = new NumSquares();

    @Test
    public void numSquares() {
        assertEquals(2, n.numSquares(13));
    }

    @Test
    public void numSquares2() {
        assertEquals(3, n.numSquares(12));
    }
}