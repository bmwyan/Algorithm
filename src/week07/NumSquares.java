package week07;

import java.util.Arrays;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week07
 * @Description: LEECODE279 完全平方数
 * @date Date : 2021年05月18日 23:55
 */
public class NumSquares {


    public int numSquares(int n) {
        int[] dp = new int[n + 1];

        //dp[i]表示到i的完全平方数的个数
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int maxSquareIndex = (int) Math.sqrt(n) + 1;
        int[] squares = new int[maxSquareIndex];
        for (int i = 1; i < maxSquareIndex; i++) {
            squares[i] = i * i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < maxSquareIndex; j++) {
                if (i >= squares[j]) {
                    dp[i] = Math.min(dp[i], dp[i - squares[j]] + 1);
                }

            }
        }
        return dp[n];
    }


    public int numSquares2(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];

    }

}
