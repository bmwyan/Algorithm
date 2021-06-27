package week12;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week12
 * @Description: 完全背包问题，不限制物品个数
 * @date Date : 2021年06月23日 0:08
 */
public class Bag02 {

    /**
     * @param value
     * @param weight
     * @param total
     * @return
     */
    public int knapsack(int[] value, int[] weight, int total) {
        int m = value.length, n = total;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }

        //其中dp[i][j]表示当前容量为j的情形下放入物品i后的最大价值
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= weight[i - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }

        return dp[m][n];
    }

    /**
     * 进行空间优化，只要记录dp[i][j]和dp[i-1][j]
     *
     * @param value
     * @param weight
     * @param total
     * @return
     */
    public int knapsack2(int[] value, int[] weight, int total) {
        int m = value.length, n = total;
        int[][] dp = new int[2][n + 1];
        for (int i = 0; i <= 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }

        //其中dp[i][j]表示当前容量为j的情形下放入物品i后的最大价值
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int ctn = i % 2;
                int ptn = 1 - ctn;

                dp[ctn][j] = dp[ptn][j];
                if (j >= weight[i - 1]) {
                    dp[ctn][j] = Math.max(dp[ctn][j], dp[ctn][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }

        return dp[m%2][n];
    }


    /**
     * @param value
     * @param weight
     * @param total
     * @return
     */
    public int knapsack3(int[] value, int[] weight, int total) {
        int m = value.length, n = total;
        int[][] dp = new int[m + 1][n + 1];
        //其中dp[i][j]表示当前容量为j的情形放入前物品i后的最大价值

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }


        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                for (int k = 0; k <= j / weight[i - 1]; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * weight[i - 1]] + k * value[i - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
