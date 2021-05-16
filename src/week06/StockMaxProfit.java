package week06;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week06
 * @Description: leecode121 股票买卖的最佳时机
 * @date Date : 2021年05月13日 23:45
 */
public class StockMaxProfit {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        //DP[i][0]表示第i天持不有股票的最大利润
        //DP[i][1]表示第i天持有股票的最大利润
        dp[0][1] = -prices[0];
        dp[0][0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            //只能买卖1次
            dp[i][1] = Math.max(dp[0][0] - prices[i], dp[i - 1][1]);

        }
        return dp[n - 1][0];

    }
}
