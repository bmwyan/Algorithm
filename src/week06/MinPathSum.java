package week06;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week06
 * @Description: Leecode64 最小路径和
 * @date Date : 2021年05月09日 23:46
 */
public class MinPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];

                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];

                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
                }
            }
        return dp[m - 1][n - 1];
    }

}
