package week09;

import java.util.*;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week09
 * @Description: leecode406 青蛙过河
 * @date Date : 2021年06月01日 22:56
 */
public class FrogCross {

    /**
     * dp解法
     *
     * @param stones
     * @return
     */
    public boolean canCross(int[] stones) {
        int n = stones.length;
        if (stones[1] != 1) {
            return false;
        }

        boolean[][] dp = new boolean[n + 1][n + 1];
        //dp[i][j]表示当前位置在i,且是以j跳跃至i时，是否到达最后一块石子的状态
        //dp[i][k] 表示青蛙能否达到「现在所处的石子编号」为 i 且「上一次跳跃距离」为 k 的状态

        //转移方程 ：dp[i][k]=dp[j][k-1]||dp[j][k]||dp[j][k+1]
        //初始值 dp[1][1]=true;
        dp[1][1] = true;
        for (int i = 2; i < n; i++)
            for (int j = 0; j < i; j++) {
                int k = stones[i] - stones[j];
                if (k <= j + 1) {
                    dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                }
            }

        for (int i = 1; i < n; i++) {
            if (dp[n - 1][i]) {
                return true;
            }
        }

        return false;
    }

    /**
     * BFS解法(时间有点长 139 ms, 在所有 Java 提交中击败了8.01%的用户)
     *
     * @param stones
     * @return
     */
    public boolean canCross2(int[] stones) {
        int[] directions = new int[]{-1, 0, 1};
        int destPostion = stones[stones.length - 1];

        Set<Integer> stonePositions = new HashSet<Integer>();
        Set<String> visited = new HashSet<String>();
        for (int stone : stones) {
            stonePositions.add(stone);
        }

        Queue<int[]> queue = new LinkedList<int[]>();
        int[] first = new int[]{stones[0], 0};
        queue.add(first);
        visited.add(stones[0] + "_" + 0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] stone = queue.poll();
                int position = stone[0];
                int lastStep = stone[1];
                for (int j = 0; j < directions.length; j++) {
                    int nextStep = lastStep + directions[j];
                    int nextPostion = position + nextStep;
                    //不能往回走
                    if (nextPostion <= position) {
                        continue;
                    }
                    if (visited.contains(nextPostion + "_" + nextStep)) {
                        continue;
                    }

                    if (stonePositions.contains(nextPostion)) {
                        queue.add(new int[]{nextPostion, nextStep});
                        visited.add(nextPostion + "_" + nextStep);

                        if (nextPostion >= destPostion) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }


}
