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

    public int numIslands(char[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    num++;
                }
            }
        }
        return num;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (!inArea(grid, i, j)) {
            return;
        }
        if (grid[i][j] != '1') {
            return;
        }

        if (grid[i][j] == '1') {
            //遍历过标识成2
            grid[i][j] = '2';
            dfs(grid, i + 1, j);
            dfs(grid, i - 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i, j - 1);
        }
    }

    private boolean inArea(char[][] grid, int i, int j) {
        boolean flag = false;
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length) {
            flag = true;
        }
        return flag;
    }
}
