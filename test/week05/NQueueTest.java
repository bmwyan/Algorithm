package week05;

import org.junit.Test;

import static org.junit.Assert.*;

public class NQueueTest {
    NQueue queen = new NQueue();

    @Test
    public void solveNQueens() {
        queen.solveNQueens(3);

    }
}