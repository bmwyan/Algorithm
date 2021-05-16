package week06;

import org.junit.experimental.max.MaxHistory;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week06
 * @Description: LEECODE 546股票买卖IV 最多交易K次
 * @date Date : 2021年05月15日 23:07
 */
public class StockMaxProfitIV {

    /**
     * 买入的次数作为交易次数
     *
     * @param K
     * @param prices
     * @return
     */
    public int maxProfit(int K, int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        K = Math.min(K, n / 2);
        int[][][] dp = new int[n][K + 1][2];
        //DP[i][k][0]:第i天不持有股票交易了K次的最大利润,以买入次数作为交易次数
        //DP[i][k][1]:第i天持有股票交易了K次的最大利润
        //边界初始化 i=0;
        for (int k = 0; k <= K; k++) {
            dp[0][k][0] = 0;
            dp[0][k][1] = -prices[0];
        }

        //k=0初始化
        for (int i = 0; i < n; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = 0;
        }

        for (int i = 1; i < n; i++)
            for (int k = 1; k <= K; k++) {
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        int res = Integer.MIN_VALUE;
        for (int k = 0; k <= K; k++) {
            res = Math.max(res, dp[n - 1][k][0]);
        }
        return res;
    }
}
