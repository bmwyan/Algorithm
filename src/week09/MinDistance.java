package week09;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week09
 * @Description: leecode72 编辑距离
 * @date Date : 2021年06月05日 23:29
 */
public class MinDistance {

    public int minDistance(String word1, String word2) {

        int m = word1.length(), n = word2.length();


        int[][] dp = new int[m + 1][n + 1];
        for(int i=0;i<=m;i++){
            dp[i][0]=i;
        }
        for(int j=0;j<=n;j++){
            dp[0][j]=j;
        }

        //dp[i][j]表示 word1的0..i 与word2 0..j所使用的最小操作数
        //插入字符  dp[i][j]=dp[i][j-1]+1;
        //删除字符: dp[i][j]=dp[i-1][j]+1;
        //修改字符 dp[i][j]=dp[i-1][j-1]+1

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1));
                }
            }

        }

        return dp[m][n];
    }


}
