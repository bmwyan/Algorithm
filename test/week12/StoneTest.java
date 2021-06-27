package week12;

import org.junit.Test;

import static org.junit.Assert.*;

public class StoneTest {
    Stone s = new Stone();

    @Test
    public void rock() {
        assertEquals(0,s.rock(new int[]{1, 2, 1, 7, 9, 4}));
    }

    @Test
    public void rock2() {
        assertEquals(0,s.rock(new int[]{4,3,4,3,2}));
    }



}