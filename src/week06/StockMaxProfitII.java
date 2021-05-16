package week06;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week06
 * @Description: TODO
 * @date Date : 2021年05月14日 0:24
 */
public class StockMaxProfitII {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        //DP[i][0]表示第i天持不有股票的最大利润
        //DP[i][1]表示第i天持有股票的最大利润
        dp[0][1] = -prices[0];
        dp[0][0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            //可以买卖多次
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);

        }
        return dp[n - 1][0];
    }
}
