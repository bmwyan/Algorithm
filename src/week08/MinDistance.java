package week08;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week08
 * @Description: leecode72 编辑距离
 * @date Date : 2021年05月25日 23:46
 */
public class MinDistance {

    public int minDistance(String word1, String word2) {

        int m = word1.length(), n = word2.length();
        if (m == 0 || n == 0) {
            return Math.max(m, n);
        }

        int[][] dp = new int[m + 1][n + 1];
        //dp[i][j]表示word1 0..i 个字符与word2 0..j个字符的最小操作数
        //转移方程如下：
        //插入一个字符 dp[i][j]=dp[i][j-1]+1;
        //删除一个字符 dp[i-1][j]+1
        //修改一个字符dp[i-1][j-1]+1


        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                char c1 = word1.charAt(i - 1);
                char c2 = word2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j]));
                }
            }


        return dp[m][n];
    }
}
