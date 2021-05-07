package week06;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchMatrixTest {
    SearchMatrix s = new SearchMatrix();

    @Test
    public void searchMatrix() {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        assertEquals(true, s.searchMatrix(matrix, 3));
    }

    @Test
    public void searchMatrix2() {
        int[][] matrix = {{1, 3}};
        assertEquals(true, s.searchMatrix(matrix, 3));
    }


    @Test
    public void searchMatrix3() {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        assertEquals(true, s.searchMatrix(matrix, 11));
    }

}