package week10;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week10
 * @Description: leecode1143最长公共子序列
 * @date Date : 2021年06月08日 22:58
 */
public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        //dp[i][j]表示text1 0..i 与text2 0..j 中最长公共子序列的长度
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }

        return dp[m][n];
    }
}
