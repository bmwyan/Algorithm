package week11;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week11
 * @Description: leecode322 零钱兑换
 * @date Date : 2021年06月18日 23:11
 */
public class CoinChange {
    private int count = Integer.MAX_VALUE;

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

        backTracking(coins, amount, 0, 0, 0);
        if (count == Integer.MAX_VALUE) {
            count = -1;
        }

        return count;

    }

    private void backTracking(int[] coins, int amount, int index, int sum, int nums) {
        System.out.println("index=" + index + ",count:" + count + ",sum=" + sum + ",amount:" + amount);
        if (count < nums) {
            return;
        }
        if (sum == amount) {
            count = Math.min(count, nums);
            return;
        }

        if (index == coins.length) {
            return;
        }

        for (int i = index; i < coins.length; i++) {
            int coinValue = coins[i];
            int temp = (amount - sum) / coinValue;
            for (int j = temp; j >= 0; j--) {
                sum += j * coinValue;
                nums += j;

                this.backTracking(coins, amount, index + 1, sum, nums);
                sum -= j * coinValue;
                nums -= j;
            }
        }
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
