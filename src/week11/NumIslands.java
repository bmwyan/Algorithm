package week11;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week11
 * @Description: leecode200 岛屿数量
 * @date Date : 2021年06月16日 21:51
 */
public class NumIslands {
    int[] directions = new int[]{-1, 0, 1, 0, -1};

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }

            }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (!valid(grid, i, j)) return;
        if (grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '2';
        for (int k = 0; k < 4; k++) {
            int x = i + directions[k];
            int y = j + directions[k + 1];
            dfs(grid,x,y);
        }
    }

    private boolean valid(char[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }

}
