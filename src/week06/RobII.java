package week06;

import java.util.Arrays;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week06
 * @Description: leecode213打家劫舍
 * @date Date : 2021年05月13日 1:08
 */
public class RobII {
    public int rob(int[] nums) {
        int m = nums.length;
        if (m < 2) {
            return nums[0];
        }

        int[] num1 = Arrays.copyOfRange(nums, 0, m - 1);
        int[] num2 = Arrays.copyOfRange(nums, 1, m);
        //从头开始偷
        int value1 = subRob(num1);
        int value2 = subRob(num2);
        return Math.max(value1, value2);
    }

    public int subRob(int[] nums) {
        int m = nums.length;
        if (m <= 1) {
            return nums[0];
        }

        int[] dp = new int[m];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < m; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[m - 1];
    }
}
