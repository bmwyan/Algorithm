package week05.dp;

import java.util.Arrays;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week05.dp
 * @Description: leecoe62 不同路径
 * @date Date : 2021年05月02日 19:56
 */
public class UniquePaths {
    /**
     * 自顶向下
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        //dp[i][j]表示从start走到i,j的路径数
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (j == 0 || i == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        return dp[m - 1][n - 1];
    }

    /**
     * 自下向上
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
        //dp[i][j]表示从end到i,j的路径数
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--)
            for (int j = n - 1; j >= 0; j--) {
                if (j == n - 1 || i == m - 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        return dp[0][0];
    }

    /**
     * 内存优化
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths3(int m, int n) {
        //dp[j]第某行第j列的路径数量为dp[j]
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j - 1] + dp[j];
            }
        return dp[n - 1];
    }

}
