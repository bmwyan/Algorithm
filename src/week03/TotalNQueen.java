package week03;

import java.util.Arrays;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week03
 * @Description: TODO
 * @date Date : 2021年04月13日 23:42
 */
public class TotalNQueen {
    Integer count = 0;

    public int totalNQueens(int n) {
        //初始化棋盘
        char[][] chess = new char[n][n];
        for (char[] row : chess) {
            Arrays.fill(row, '.');
        }

        //回溯
        backTrace(chess, n, 0);
        return count;
    }

    private void backTrace(char[][] chess, int n, int row) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            boolean flag = valid(chess, n, row, col);
            if (!flag) {
                continue;
            }

            chess[row][col] = 'Q';
            this.backTrace(chess, n, row + 1);
            chess[row][col] = '.';
        }
    }

    private boolean valid(char[][] chess, int n, int row, int col) {
        //同一列中是否有Queue
        for (int i = 0; i < n; i++) {
            if (chess[i][col] == 'Q') {
                return false;
            }
        }

        //左斜上方
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }

        //右斜上方
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
