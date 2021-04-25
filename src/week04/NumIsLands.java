package week04;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week04
 * @Description: leecode200 岛屿数量
 * @date Date : 2021年04月24日 14:31
 */
public class NumIsLands {
    private int[] directions = new int[]{-1, 0, 1, 0, -1};

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
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] != '1') {
            return;
        }


        if (grid[i][j] == '1') {
            grid[i][j] = '2';
            for (int k = 0; k < 4; k++) {
                dfs(grid, i + directions[k], j + directions[k + 1]);
            }
        }
    }
}
