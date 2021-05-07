package week04;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week04
 * @Description: leecode 统计封闭岛屿的数目
 * @date Date : 2021年04月24日 15:46
 */
public class ClosedIslandDFS {
    private int[] directions = {-1, 0, 1, 0, -1};

    public int closedIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    boolean flag = dfs(grid, i, j);
                    if (flag) {
                        res++;
                    }

                }
            }
        return res;
    }

    private boolean dfs(int[][] grid, int i, int j) {
        if (inValid(grid, i, j)) {
            return false;
        }

        if (grid[i][j] != 0) {
            return true;
        }

        boolean flag = true;
        if (grid[i][j] == 0) {
            grid[i][j] = 2;

            boolean up = dfs(grid, i - 1, j);
            boolean down = dfs(grid, i + 1, j);
            boolean right = dfs(grid, i, j + 1);
            boolean left = dfs(grid, i, j - 1);
            return up && down && right && left;

        }
        return true;
    }

    private boolean inValid(int[][] grid, int i, int j) {
        return i < 0 || i >= grid.length || j < 0 || j >= grid[0].length;
    }


}
