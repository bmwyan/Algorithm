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

    private boolean isClosedIsLand = true;

    public int closedIsland(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    isClosedIsLand = true;
                    dfs2(grid, i, j);
                    if (isClosedIsLand) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private void dfs2(int[][] grid, int i, int j) {
        if (!inArea(grid, i, j)) {
            isClosedIsLand = false;
            return;
        }
        if (grid[i][j] != 0) {
            return;
        }

        if (grid[i][j] == 0) {
            grid[i][j] = 2;
            dfs2(grid, i, j + 1);
            dfs2(grid, i, j - 1);
            dfs2(grid, i + 1, j);
            dfs2(grid, i - 1, j);
        }
    }


    /**
     * dfs有返回值的方式
     *
     * @param grid
     * @return
     */
    public int closedIsland2(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    boolean flag = dfs(grid, i, j);
                    if (flag) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private boolean dfs(int[][] grid, int i, int j) {
        boolean flag = false;
        if (!inArea(grid, i, j)) {
            return false;
        }
        if (grid[i][j] != 0) {
            return true;
        }

        if (grid[i][j] == 0) {
            grid[i][j] = 2;

            boolean up = dfs(grid, i - 1, j);
            boolean down = dfs(grid, i + 1, j);
            boolean right = dfs(grid, i, j + 1);
            boolean left = dfs(grid, i, j - 1);
            return up && down && right && left;
        }
        return flag;
    }

    private boolean inArea(int[][] grid, int i, int j) {
        boolean flag = false;
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length) {
            flag = true;
        }
        return flag;
    }
}
