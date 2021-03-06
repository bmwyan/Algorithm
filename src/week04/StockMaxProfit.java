package week04;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week04
 * @Description: leecode122 买卖股票的最佳时机 II
 * @date Date : 2021年04月24日 13:57
 */
public class StockMaxProfit {

    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                sum += prices[i] - prices[i - 1];
            }

        }
        return sum;
    }
}
