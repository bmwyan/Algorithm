package week04;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindContentChildrenTest {
    FindContentChildren f = new FindContentChildren();

    @Test
    public void findContentChildren() {
        assertEquals(2, f.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
    }
}