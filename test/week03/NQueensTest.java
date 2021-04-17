package week03;

import org.junit.Test;

import static org.junit.Assert.*;

public class NQueensTest {
    NQueens queens = new NQueens();

    @Test
    public void solveNQueens() {
        queens.solveNQueens(1);
    }

    @Test
    public void solveNQueens2() {
        queens.solveNQueens(2);
    }

    @Test
    public void solveNQueens4() {
        queens.solveNQueens(4);
    }
}