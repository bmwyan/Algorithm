package week01;

import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveDuplicatesTest {
    RemoveDuplicates d = new RemoveDuplicates();

    @Test
    public void removeDuplicates() {
        int act = d.removeDuplicates(new int[]{1,1,2});
        assertEquals(2,act);
    }
}