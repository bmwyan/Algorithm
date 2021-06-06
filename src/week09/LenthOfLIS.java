package week09;

import java.util.Arrays;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week09
 * @Description: leecode300 最长递增子序列
 * @date Date : 2021年06月04日 23:37
 */
public class LenthOfLIS {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        //dp[i]表示以nums[i]结尾的递增字序列，必须要含有nums[i]
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
