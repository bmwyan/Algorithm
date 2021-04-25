package week04;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week04
 * @Description: leecode827 最大人工岛
 * @date Date : 2021年04月24日 22:13
 */
public class LargestIsland {

    private int[] directions = new int[]{-1, 0, 1, 0, -1};

    public int largestIsland(int[][] grid) {
        int res = 0;
        int index = 2;
        Map<Integer, Integer> map = new HashMap<>();

        //DFS遍历获取每个索引对应的岛
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, index);
                    map.put(index, area);
                    res = Math.max(res, area);
                    index++;
                }
            }

        if (res == 0) {
            return 1;
        }

        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                //海洋
                if (grid[i][j] == 0) {
                    //查看四周是否存在岛屿
                    HashSet<Integer> set = findNeiborghors(grid, i, j);
                    if (set.size() < 1) {
                        continue;
                    }
                    int areaid = 1;
                    for (int iIndex : set) {
                        areaid += map.get(iIndex);
                        res = Math.max(res, areaid);
                    }

                }
            }


        return res;
    }

    private HashSet<Integer> findNeiborghors(int[][] grid, int i, int j) {
        HashSet<Integer> set = new HashSet<>();
        for (int k = 0; k < 4; k++) {
            int x = i + directions[k];
            int y = j + directions[k + 1];
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
                continue;
            }
            if (grid[x][y] == 0) {
                continue;
            }
            if (!set.contains(grid[x][y])) {
                set.add(grid[x][y]);
            }

        }
        return set;
    }

    private int dfs(int[][] grid, int i, int j, int index) {
        int sum = 0;
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        if (grid[i][j] == index) {
            return 0;
        }

        if (grid[i][j] == 1) {
            grid[i][j] = index;
            sum += 1;
            for (int k = 0; k < 4; k++) {
                sum += dfs(grid, i + directions[k], j + directions[k + 1], index);
            }
        }
        return sum;
    }

}

