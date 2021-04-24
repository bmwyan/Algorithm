package week04;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week04
 * @Description: leecode1254 统计封闭岛数目
 * @date Date : 2021年04月24日 17:14
 */
public class ClosedIsLandBFS {

    private int[] directions = new int[]{-1, 0, 1, 0, -1};

    public int closedIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    res += bfs(grid, i, j);
                }

            }
        }

        return res;
    }

    private int bfs(int[][] grid, int i, int j) {
        int count = 1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            grid[cell[0]][cell[1]] = 2;
            for (int k = 0; k < 4; k++) {
                int x = cell[0] + directions[k];
                int y = cell[1] + directions[k + 1];
                if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
                    count= 0;
                    //此处不能跳出循环，因为需要再遍历连接的岛
                    continue;
                }
                if (grid[x][y] == 0) {
                    //grid[x][y] = 2;
                    queue.add(new int[]{x, y});
                }
            }
        }
        return count;
    }

}
