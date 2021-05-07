package week05.dp;

import org.junit.Test;

import static org.junit.Assert.*;

public class UniquePathsTest {
    UniquePaths u = new UniquePaths();

    @Test
    public void uniquePaths() {
        assertEquals(28, u.uniquePaths(3, 7));
    }
}