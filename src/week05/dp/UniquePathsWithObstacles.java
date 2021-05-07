package week05.dp;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week05.dp
 * @Description: leeecode63 不同路径II 有障碍物
 * @date Date : 2021年05月02日 21:38
 */
public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        //有障碍物之后的所有行和列都为0
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        return dp[m - 1][n - 1];
    }
}
