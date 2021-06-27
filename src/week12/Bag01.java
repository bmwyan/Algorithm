package week12;

import java.util.Arrays;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week12
 * @Description: 0-1背包问题
 * @date Date : 2021年06月21日 23:44
 */
public class Bag01 {
    public int knapsack2(int[] value, int[] weight, int total) {
        int[][] dp = new int[value.length + 1][total + 1];
        //dp[i][j]表示最大重量为j时拿到前i个物品的最大价值
        for (int i = 0; i <= value.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= total; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= value.length; i++) {
            for (int j = 1; j <= total; j++) {
                if (j >= weight[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                } else {
                    //当背包容量小于物品容量时
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[value.length][total];
    }

    /**
     * 更符合人脑思维的理解
     *
     * @param value
     * @param weight
     * @param total
     * @return
     */
    public int knapsack(int[] value, int[] weight, int total) {
        int[][] dp = new int[total + 1][value.length + 1];
        //dp[i][j]表示当前容量为i时放入前j个物品的最大价值
        for (int i = 0; i <= total; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= value.length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= total; i++) {
            for (int j = 1; j <= value.length; j++) {

                if (i >= weight[j - 1]) {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - weight[j - 1]][j - 1] + value[j - 1]);
                } else {
                    //当背包容量小于物品容量时
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[total][value.length];
    }


}
