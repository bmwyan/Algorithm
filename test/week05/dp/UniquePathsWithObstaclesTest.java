package week05.dp;

import org.junit.Test;

import static org.junit.Assert.*;

public class UniquePathsWithObstaclesTest {
    UniquePathsWithObstacles u = new UniquePathsWithObstacles();

    @Test
    public void uniquePathsWithObstacles() {
        assertEquals(0, u.uniquePathsWithObstacles(new int[][]{{1, 0}}));
    }
}