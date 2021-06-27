package week11.coinchange;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week11.coinchange
 * @Description: TODO
 * @date Date : 2021年06月19日 23:06
 */
public class CoinChange {
    /**
     * 递归方式求解
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        int count = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, amount - coin);
            if (res >= 0) {
                count = Math.min(count, res + 1);
            }
        }
        return count == Integer.MAX_VALUE ? -1 : count;
    }
}

