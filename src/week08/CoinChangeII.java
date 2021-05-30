package week08;

/**
 * @author : admin
 * @version v1.0
 * @project: leecode
 * @package week08
 * @description: leecode518 零钱兑换ii
 * @date date : 2021年05月26日 0:06
 */
public class CoinChangeII {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if(i-coin>=0){
                    dp[i] += dp[i - coin];
                }
            }
        }

        return dp[amount];
    }
}
