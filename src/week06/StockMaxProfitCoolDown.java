package week06;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week06
 * @Description: leecode309 最佳买卖股票时机含冷冻期
 * @date Date : 2021年05月16日 22:48
 */
public class StockMaxProfitCoolDown {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n<=1){
            return 0;
        }
        int[][] dp = new int[n][3];
        //dp[i][0] 第i天持有股票的最大利润
        //dp[i][1] 第i天不持有股票且处于冷冻期的最大利润，后一天处于冷冻期「处于冷冻期」指的是在第 ii 天结束之后的状态
        //dp[i][2] 第i天不持有股票，并且不处于冷冻期的最大利润
        dp[0][0]=-prices[0];
        dp[0][1]=0;
        dp[0][2]=0;

        for (int i = 1; i < n; i++) {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][2]-prices[i]);
            dp[i][1]=dp[i-1][0]+prices[i];
            dp[i][2]=Math.max(dp[i-1][2],dp[i-1][1]);
        }

        return Math.max(dp[n-1][2],dp[n-1][1]);
    }
}
