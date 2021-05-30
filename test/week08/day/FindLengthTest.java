package week08.day;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindLengthTest {
    FindLength f = new FindLength();

    @Test
    public void findLength() {
        assertEquals(2,f.findLength(new int[]{0,1,1,1,1},new int[]{1,0,1,0,1}));
    }
}