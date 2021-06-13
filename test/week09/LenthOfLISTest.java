package week09;

import org.junit.Test;

import static org.junit.Assert.*;

public class LenthOfLISTest {
    LenthOfLIS lis = new LenthOfLIS();

    @Test
    public void lengthOfLIS() {
        assertEquals(3, lis.lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9}));
    }
}