package week11;

import java.util.Arrays;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week11
 * @Description: TODO
 * @date Date : 2021年06月19日 21:14
 */
public class CoinChangeDFSII {

    private int[] mem;

    public int coinChange(int[] coins, int amount) {
        mem = new int[amount + 1];
        mem[0] = 0;
        sort(coins);
        int res = dfs(coins, amount);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void sort(int[] coins) {
        int start = 0;
        int end = coins.length - 1;
        while (start < end) {
            int temp = coins[start];
            coins[start++] = coins[end];
            coins[end--] = temp;
        }

    }

    private int dfs(int[] coins, int rest) {
        if (rest == 0) {
            return 0;
        }
        if (rest < 0) {
            return -1;
        }
        if (mem[rest] != 0) {
            return mem[rest];
        }

        int count = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = dfs(coins, rest - coins[i]);
            if (res >= 0 && (res + 1 < count)) {
                count = res + 1;
            }
        }
        mem[rest] = (count == Integer.MAX_VALUE ? -1 : count);
        return mem[rest];
    }


}
