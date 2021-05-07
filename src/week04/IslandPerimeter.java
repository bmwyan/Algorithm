package week04;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week04
 * @Description: leecode463 岛屿周长
 * @date Date : 2021年04月24日 21:49
 */
public class IslandPerimeter {

    private int[] directions = {-1, 0, 1, 0, -1};

    public int islandPerimeter(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    sum = dfs(grid, i, j);
                }
            }
        return sum;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (inValid(grid, i, j)) {
            return 1;
        }
        if (grid[i][j] == 0) {
            return 1;
        }
        if (grid[i][j] == 2) {
            return 0;
        }

        grid[i][j] = 2;
        int sum = 0;
        for (int k = 0; k < 4; k++) {
            int x = i + directions[k];
            int y = j + directions[k + 1];
            sum += dfs(grid, x, y);
        }

        return sum;
    }

    private boolean inValid(int[][] grid, int i, int j) {
        return i < 0 || i >= grid.length || j < 0 || j >= grid[0].length;
    }


}
