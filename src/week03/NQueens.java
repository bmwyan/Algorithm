package week03;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week03
 * @Description: leecode51
 * @date Date : 2021年04月13日 22:40
 */
public class NQueens {
    /**
     * 存放结果集
     */
    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        //棋盘
        char[][] chess = new char[n][n];
        //初始化棋盘，全为.
        for (char[] row : chess) {
            Arrays.fill(row, '.');
        }
        backTrace(chess, n, 0);
        return res;
    }

    /**
     * 回溯方法
     *
     * @param chess
     * @param n
     * @param row
     */
    private void backTrace(char[][] chess, int n, int row) {
        if (row == n) {
            List<String> l = this.getBoard(chess);
            res.add(l);
            return;
        }
        for (int column = 0; column < n; column++) {
            //校验是否合适
            boolean flag = valid(chess, row, column, n);
            if (!flag) {
                continue;
            }

            //回溯
            chess[row][column] = 'Q';
            backTrace(chess, n, row + 1);
            chess[row][column] = '.';
        }
    }

    private boolean valid(char[][] chess, int row, int column, int n) {
        //所在行不能有Q
        for (int i = 0; i < n; i++) {
            if (chess[i][column] == 'Q') {
                return false;
            }
        }
        //两个斜线方向上不能有Q
        //1).左上方斜线
        for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        //2).右上方斜线
        for (int i = row - 1, j = column + 1; i >= 0 && j < n; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    /**
     * 转换成对应的符号
     * @param chess
     * @return
     */
    private List<String> getBoard(char[][] chess) {
        List<String> list = new ArrayList<>();
        for (char[] row : chess) {
            list.add(String.valueOf(row));
        }
        return list;
    }

}
