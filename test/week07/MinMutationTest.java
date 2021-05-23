package week07;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinMutationTest {
    MinMutation m = new MinMutation();

    @Test
    public void minMutation() {
        int actual = m.minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"});
        assertEquals(2, actual);
    }

    @Test
    public void minMutation2() {
        int actual = m.minMutation("AAAAAAAA", "CCCCCCCC", new String[]{"AAAAAAAA", "AAAAAAAC", "AAAAAACC", "AAAAACCC", "AAAACCCC", "AACACCCC", "ACCACCCC", "ACCCCCCC", "CCCCCCCA", "CCCCCCCC"});
        assertEquals(8, actual);
    }


}