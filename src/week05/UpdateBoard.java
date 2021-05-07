package week05;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week05
 * @Description: leecode529 扫雷游戏
 * @date Date : 2021年04月26日 23:11
 */
public class UpdateBoard {

    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0], col = click[1];
        //挖到地雷，游戏结
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
        } else {
            dfs(board, row, col);
        }
        return board;
    }

    private void dfs(char[][] board, int row, int col) {
        //超过边界
        if (!valid(board, row, col) || board[row][col] != 'E') {
            return;
        }

        int count = 0;//附近地雷数
        for (int[] direction : directions) {
            int x = row + direction[0];
            int y = col + direction[1];
            if (!valid(board, x, y)) {
                continue;
            }
            if (board[x][y] == 'M') {
                count++;
            }
        }
        if (count != 0) {
            board[row][col] = (char) (count + '0');
        } else {
            if (board[row][col] == 'E') {
                board[row][col] = 'B';
                for (int[] direction : directions) {
                    int x = row + direction[0];
                    int y = col + direction[1];
                    dfs(board, x, y);
                }
            }
        }
    }

    private boolean valid(char[][] board, int row, int col) {
        return !(row < 0 || row >= board.length || col < 0 || col >= board[0].length);

    }


}
