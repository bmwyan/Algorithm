package week11;

import java.util.Arrays;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week11
 * @Description: leecode322 零钱兑换
 * @date Date : 2021年06月18日 23:11
 */
public class CoinChangeDFS {
    int[] mem;
    public int coinChange(int[] coins, int amount) {
        mem = new int[amount + 1];
        Arrays.sort(coins);
        return dfs(coins, amount);
    }

    private int dfs(int[] coins, int sum) {
        if (sum == 0) {
            return 0;
        }

        if (sum < 0) {
            return -1;
        }

        if (mem[sum] != 0) {
            return mem[sum];
        }
        int count = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = dfs(coins, sum - coin);
            if (res >= 0 && (res + 1 <= count)) {
                count = res + 1;
            }
        }
        mem[sum] = (count == Integer.MAX_VALUE ? -1 : count);
        return mem[sum];
    }
}
