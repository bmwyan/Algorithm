package week11.coinchange;

import java.util.Arrays;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week11.coinchange
 * @Description: TODO
 * @date Date : 2021年06月19日 23:06
 */
public class CoinChangeMem {
    /**
     * 递归方式求,采用结果备忘录的方式
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        int[] mem = new int[amount + 1];
        Arrays.fill(mem, -2);
        return coinChange(coins, amount, mem);
    }


    public int coinChange(int[] coins, int rest, int[] mem) {
        if (rest == 0) {
            return 0;
        }
        if (rest < 0) {
            return -1;
        }

        if (mem[rest] != -2) {
            return mem[rest];
        }

        int count = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rest - coin, mem);
            if (res >= 0) {
                count = Math.min(count, res + 1);
            }
        }
        mem[rest] = count == Integer.MAX_VALUE ? -1 : count;
        return mem[rest];
    }
}

