package week07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week07
 * @Description: leecode51 N皇后
 * @date Date : 2021年05月23日 23:38
 */
public class NQueue {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] grid = new char[n][n];
        for (char[] row : grid) {
            Arrays.fill(row, '.');
        }
        backTracking(grid, n, 0);
        return res;
    }

    private void backTracking(char[][] grid, int n, int row) {
        if (row == n) {
            List<String> list = generateResult(grid);
            res.add(list);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (!valid(grid, row, col)) {
                continue;
            }
            grid[row][col] = 'Q';
            this.backTracking(grid, n, row + 1);
            grid[row][col] = '.';

        }
    }

    private boolean valid(char[][] grid, int row, int col) {
        //判断3个方向上是否有Q
        //同一列上
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][col] == 'Q') {
                return false;
            }
        }

        //左对角线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (grid[i][j] == 'Q') {
                return false;
            }
        }

        //右对角线
        int n = grid.length;
        for (int i = row - 1, j = col + 1; i >=0 && j < n; i--, j++) {
            if (grid[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private List<String> generateResult(char[][] grid) {
        List<String> list = new ArrayList<>();
        for (char[] c : grid) {
            list.add(String.valueOf(c));
        }
        return list;
    }
}
