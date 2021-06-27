package week12;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week12
 * @Description: 破碎石头
 * @date Date : 2021年06月23日 21:19
 */
public class Stone {
/*
    问题：有一堆石头，每块石头的重量都是正整数。每次从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x≤y。
    那么粉碎的可能结果如下：如果 x 与 y 相等，那么两块石头都会被完全粉碎；否则，重量为 x 的石头将会完全粉碎，
    而重量为 y 的石头的新重量为 y−x。最后，最多只会剩下一块石头。返回此时石头最小的可能重量。如果没有石头剩下，就返回 0。

 */

    public int rock(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        int maxSize = sum % 2 == 0 ? sum / 2 : (sum / 2 + 1);
        int n = stones.length;

        int[][] dp = new int[n + 1][maxSize + 1];
        //dp[i][j]表示容量余下j时放入前i个物品的最大价值
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= maxSize; j++) {

                if (j >= stones[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        int res2 = sum - dp[n][maxSize];
        int res1 = Math.abs(dp[n][maxSize] - res2);
        return 0;
    }


    public int rock2(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        int maxSize = sum % 2 == 0 ? sum / 2 : (sum / 2 + 1);
        int n = stones.length;

        int[][] dp = new int[2][maxSize + 1];
        //dp[i][j]表示容量余下j时放入前i个物品的最大价值
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= maxSize; j++) {
                int cur = i % 2;
                int pre = 1 - cur;

                if (j >= stones[i - 1]) {
                    dp[cur][j] = Math.max(dp[pre][j], dp[pre][j - stones[i - 1]] + stones[i - 1]);
                } else {
                    dp[cur][j] = dp[pre][j];
                }

            }
        }
        int res2 = sum - dp[n % 2][maxSize];
        int res1 = Math.abs(dp[n % 2][maxSize] - res2);
        return 0;
    }
}
