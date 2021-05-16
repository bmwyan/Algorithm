package week06;

import java.util.List;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week06
 * @Description: LEECODE120 三角形最小路径和
 * @date Date : 2021年05月09日 22:36
 */
public class MinimumTotal {
    /**
     * 动态规划，自底向上
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size(), n = triangle.get(m - 1).size();
        int[][] dp = new int[m + 1][n + 1];

        //dp[i][j]表示到i,j坐标的最小路径和，采用自底向上
        for (int i = m - 1; i >= 0; i--) {
            int cols = triangle.get(i).size();
            for (int j = 0; j < cols; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }

        return dp[0][0];
    }

    /**
     * 动态规划，自顶向下
     *
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        int m = triangle.size(), n = triangle.get(m - 1).size();
        int[][] dp = new int[m][n];
        dp[0][0] = triangle.get(0).get(0);
        //dp[i,j]表示从顶到i,j的最小路径和
        //dp[i,j]=Min(dp[i-1][j],dp[i-1][j])+f[i][j]

        for (int i = 1; i < m; i++) {
            int cols = triangle.get(i).size();
            for (int j = 0; j < cols; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == cols - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                }

            }
        }

        int res = dp[m - 1][0];
        for (int j = 0; j < n; j++) {
            res = Math.min(res, dp[m - 1][j]);
        }

        return res;
    }

}
