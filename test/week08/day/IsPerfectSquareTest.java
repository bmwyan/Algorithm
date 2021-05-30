package week08.day;

import org.junit.Test;

import static org.junit.Assert.*;

public class IsPerfectSquareTest {
    IsPerfectSquare is = new IsPerfectSquare();

    @Test
    public void isPerfectSquare() {
        assertEquals(true,is.isPerfectSquare(16));
    }

    @Test
    public void isPerfectSquare2() {
        assertEquals(false,is.isPerfectSquare(14));
    }
}