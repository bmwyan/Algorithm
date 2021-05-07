package zniuyang.dfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package zniuyang.dfs
 * @Description: leecode934 最短的桥
 * @date Date : 2021年05月04日 23:46
 */
public class ShortestBridge {
    private int[] directions = new int[]{-1, 0, 1, 0, -1};
    private boolean isFirst = false;

    public int shortestBridge(int[][] A) {
        Queue<int[]> quque = new LinkedList<>();

        int m = A.length, n = A[0].length;
        //DFS
        for (int i = 0; i < m; i++) {
            if (isFirst) {
                break;
            }
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    dfs(quque, A, i, j);
                    isFirst = true;
                    break;
                }

            }
        }

        //BFS
        return getShortestBridge(A, quque);
    }

    private int getShortestBridge(int[][] A, Queue<int[]> quque) {
        int bridge = 0;
        while (!quque.isEmpty()) {
            int size = quque.size();
            bridge++;
            for (int i = 0; i < size; i++) {
                int[] pair = quque.poll();
                for (int k = 0; k < 4; k++) {
                    int x = pair[0] + directions[k];
                    int y = pair[1] + directions[k + 1];
                    if (!valid(A, x, y)) continue;
                    if (A[x][y] == 1) return bridge;
                    if (A[x][y] == 0) {
                        A[x][y]=2;
                        quque.add(new int[]{x, y});
                    }

                }
            }

        }

        return 0;
    }

    private void dfs(Queue<int[]> queue, int[][] a, int i, int j) {
        if (!(i >= 0 && i < a.length && j >= 0 && j < a[0].length)) {
            return;
        }

        if (a[i][j] != 1) {
            return;
        }
        if (a[i][j] == 0) {
            queue.add(new int[]{i, j});
        }

        a[i][j]=2;
        for (int k = 0; k < 4; k++) {
            int x = i + directions[k];
            int y = j + directions[k + 1];
            boolean flag = valid(a, x, y);


            dfs(queue, a, x, y);
        }
    }

    private boolean valid(int[][] a, int i, int j) {
        if (!(i >= 0 && i < a.length && j >= 0 && j < a[0].length)) {
            return false;
        }
        return true;
    }


}
