package week11.coinchange;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week11
 * @Description: leecode322 零钱兑换
 * @date Date : 2021年06月18日 23:11
 */
public class CoinChangeMem2 {

    private HashMap<Integer, Integer> mem = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int start = 0;
        int end = coins.length - 1;
        while (start < end) {
            int temp = coins[start];
            coins[start++] = coins[end];
            coins[end--] = temp;
        }

        int count = backTracking(coins, amount);
        return count == Integer.MAX_VALUE ? -1 : count;


    }

    private int backTracking(int[] coins, int rest) {
        if (rest == 0) {
            return 0;
        }
        if (rest < 0) {
            return -1;
        }

        if (mem.containsKey(rest)) {
            return mem.get(rest);
        }

        int count = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = this.backTracking(coins, rest - coins[i]);
            if (res >= 0) {
                count = Math.min(count, res + 1);
            }
        }
        count = count == Integer.MAX_VALUE ? -1 : count;
        mem.put(rest, Integer.valueOf(count));
        return count;
    }
    
}
