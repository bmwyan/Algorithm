package week04;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week04
 * @Description: TODO
 * @date Date : 2021年04月24日 21:49
 */
public class IslandPerimeter {
    private int[] directions = new int[]{-1, 0, 1, 0, -1};

    public int islandPerimeter(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    sum = dfs(grid, i, j);
                }
            }
        }

        return sum;
    }

    private int dfs(int[][] grid, int i, int j) {
        int sum = 0;
        //从一个网格走向边界，周长+1
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 1;
        }

        //边界是海洋，
        if (grid[i][j] == 0) {
            return 1;
        }
        if (grid[i][j] == 2) {
            return 0;
        }

        grid[i][j] = 2;
        for (int k = 0; k < 4; k++) {
            sum += dfs(grid, i + directions[k], j + directions[k + 1]);
        }

        return sum;
    }
}
