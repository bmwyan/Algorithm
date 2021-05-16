package week06;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week06
 * @Description: leecode53 最大子序和
 * @date Date : 2021年05月16日 14:56
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        //dp[i]表示以nums[i]结尾的最大子序和
        int res = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    public int maxSubArray2(int[] nums) {
        int sum = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            res = Math.max(res, sum);

        }
        return sum;
    }


}
