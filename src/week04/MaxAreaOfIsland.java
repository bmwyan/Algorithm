package week04;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week04
 * @Description: leecode695 岛屿的最大面积
 * @date Date : 2021年04月24日 15:26
 */
public class MaxAreaOfIsland {

    private int[] directoions = new int[]{-1, 0, 1, 0, -1};

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int depth = dfs(grid, i, j);
                    res = Math.max(res, depth);
                }
            }
        }

        return res;
    }

    private int dfs(int[][] grid, int i, int j) {
        int count = 0;
        if (!inArea(grid, i, j) || grid[i][j] != 1) {
            return 0;
        }
        if (grid[i][j] == 1) {
            count++;
            grid[i][j] = 2;
            for (int k = 0; k < 4; k++) {
                count += dfs(grid, i + directoions[k], j + directoions[k + 1]);
            }
        }

        return count;
    }

    private boolean inArea(int[][] grid, int i, int j) {
        boolean flag = false;
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length) {
            flag = true;
        }
        return flag;
    }
}
