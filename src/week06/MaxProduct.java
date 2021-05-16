package week06;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week06
 * @Description: leecode 乘积最大子数组
 * @date Date : 2021年05月16日 23:46
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return nums[0];
        }
        int[][] dp = new int[n][2];
        //dp[i][0]表示以0~i 以nums[i]结尾的最大乘积
        //dp[i][1]表示以0~i 以nums[i]结尾的最小乘积
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int res = dp[0][1];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] * nums[i], Math.max(nums[i], dp[i - 1][1] * nums[i]));
            dp[i][1] = Math.min(dp[i - 1][1] * nums[i], Math.min(nums[i], dp[i - 1][0] * nums[i]));
            res = Math.max(res, dp[i][0]);
        }
        return res;
    }
}
