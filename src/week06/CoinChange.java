package week06;

import java.util.Arrays;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week06
 * @Description: leecode322 零钱况换
 * @date Date : 2021年05月12日 0:32
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0]=0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }

        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
