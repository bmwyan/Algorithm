package week06;

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
     * @param K
     * @param prices
     * @return
     */
    public int maxProfit(int K, int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        K = Math.min(K, n / 2);
        int[][][] mp = new int[n][K + 1][2];
        //mp[i][k][0] 到第i天未未持有股票已交易k次的最大利润， 其中 买入股票时作为一次交易
        //mp[i][k][1] 到第i天持有股票已交易k次的最大利润
        int maxValue = 0;

        //需要考虑边界i=0
        for (int k = 0; k <= K; k++) {
            mp[0][k][0] = 0;
            mp[0][k][1] = -prices[0];
        }

        for (int i = 1; i < n; i++) {
            for (int k = 1; k <= K; k++) {
                mp[i][k][0] = Math.max(mp[i - 1][k][0], mp[i - 1][k][1] + prices[i]);
                mp[i][k][1] = Math.max(mp[i - 1][k][1], mp[i - 1][k - 1][0] - prices[i]);
            }
        }

        for (int k = 0; k <= K; k++) {
            maxValue = Math.max(maxValue, mp[n - 1][k][0]);
        }
        return maxValue;
    }
}
