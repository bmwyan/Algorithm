package week05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week05
 * @Description: leecode51
 * @date Date : 2021年04月29日 0:03
 */
public class NQueue {

    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        backTracking(board, n, 0);
        return res;
    }

    private void backTracking(char[][] board, int n, int row) {
        System.out.println("backTracking:" + row);
        printBoard(board);

        if (row == n) {
            List<String> list = getBoard(board);
            res.add(list);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!this.valid(board, row, col, n)) {
                System.out.println("valid board[" + row + "][" + col + "]=" + board[row][col]);
                continue;
            }
            board[row][col] = 'Q';
            //printBoard(board);
            System.out.println("board[" + row + "][" + col + "]=" + board[row][col]);
            backTracking(board, n, row + 1);
            board[row][col] = '.';

        }
    }

    private void printBoard(char[][] board) {
        for (char[] str : board) {
            System.out.println(String.valueOf(str));
        }
    }

    private List<String> getBoard(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] str : board) {
            list.add(String.valueOf(str));
        }
        return list;
    }

    private boolean valid(char[][] board, int row, int col, int n) {
        //列不能为Q
        for (int i = 0; i < n; i++) {
            // System.out.println("1=====judge board[" + i + "][" + col + "]=" + board[i][col]);
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        //左上斜线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            //System.out.println("2=====judge board[" + i + "][" + col + "]=" + board[i][col]);
            if (board[i][j] == 'Q') {
                return false;
            }

        }

        //右上斜线
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            // System.out.println("3=====judge board[" + i + "][" + col + "]=" + board[i][col]);
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
