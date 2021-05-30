package week08;

import java.util.Arrays;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week08.day
 * @Description: leecode279 完全平方数
 * @date Date : 2021年05月24日 23:55
 */
public class NumSquares {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 0; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }

        }
        return dp[n];
    }

    public int numSquares2(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int squareIndex = (int) Math.sqrt(n) + 1;
        int[] squares = new int[squareIndex];
        for (int i = 1; i < squareIndex; i++) {
            squares[i] = i * i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j<squareIndex; j++) {
                if(i>=squares[j]){
                    dp[i] = Math.min(dp[i], dp[i -squares[j]] + 1);
                }
            }

        }
        return dp[n];
    }

}
