package week04;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week04
 * @Description: TODO
 * @date Date : 2021年04月25日 21:58
 */
public class NumIsLandBFS {
    private int[] directions = new int[]{-1, 0, 1, 0, -1};

    /**
     *
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                }
            }
        return count;
    }

    /**
     * grid[i][j]在外面赋值为2，再进入队列，此时内存没有超出限制，而在里面赋值为2，则会超出内存限制
     * @param grid
     * @param i
     * @param j
     */
    private void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});
        grid[i][j]='2';
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
           // grid[cell[0]][cell[1]] = '2';
            for (int k = 0; k < 4; k++) {
                int x = cell[0] + directions[k];
                int y = cell[1] + directions[k + 1];
                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1') {
                    grid[x][y]='2';
                    queue.add(new int[]{x, y});
                }
            }
        }
    }
}
