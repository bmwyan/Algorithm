package week10;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week10
 * @Description: leecode72 编辑距离
 * @date Date : 2021年06月13日 23:55
 */
public class MinDistance {

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if (m == 0 || n == 0) {
            return m + n;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                }
            }


        return dp[m][n];
    }

}
