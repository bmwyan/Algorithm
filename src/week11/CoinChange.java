package week11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week11
 * @Description: leecode322 零钱兑换
 * @date Date : 2021年06月18日 23:11
 */
public class CoinChange {

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

        int count = backTracking(coins, amount, 0);
        return count == Integer.MAX_VALUE ? -1 : count;


    }

    private int backTracking(int[] coins, int rest, int index) {
        if (rest == 0) {
            return 0;
        }
        if (rest < 0) {
            return -1;
        }

        if (mem.containsKey(rest)) {
            return mem.get(rest);
        }
        //System.out.println("index=" + index + ",rest:" + rest);

        int count = Integer.MAX_VALUE;
        for (int i = index; i < coins.length; i++) {
            int coinValue = coins[i];
            int temp = rest / coinValue;
            for (int j = temp; j >= 0; j--) {
                rest -= j * coinValue;
                int res = this.backTracking(coins, rest, index + 1);
                if (res >= 0 && res + j < count) {
                    count = res + j;
                }
                rest += j * coinValue;
            }
        }
        count = count == Integer.MAX_VALUE ? -1 : count;
        mem.put(rest, Integer.valueOf(count));
        return count;
    }


    /**
     * 动态规划解法
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        //dp[i]表示总和为i时，最少的硬币数量
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
