package week10;

import java.util.List;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week10
 * @Description: leecode120 三角形最小路径和
 * @date Date : 2021年06月08日 21:57
 */
public class MinimumTotal {

    public int minimumTotal(List<List<Integer>> triangle) {

        int m = triangle.size();
        if (m == 0) {
            return 0;
        }
        int n = triangle.get(m - 1).size();
        int[][] dp = new int[m][n];
        //dp[i][j]表示最后一行到第i,j个元数到到顶点的路径最小和
        for (int j = 0; j < n; j++) {
            dp[m - 1][j] = triangle.get(m - 1).get(j);
        }

        for (int i = m - 2; i >= 0; i--) {
            int rows=triangle.get(i).size();
            for (int j = 0; j < rows; j++) {
                int num = triangle.get(i).get(j);
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + num;
            }
        }
        return dp[0][0];
    }

}
