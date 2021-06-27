package week12;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week12
 * @Description: LEECODE55 跳跃游戏
 * @date Date : 2021年06月25日 0:10
 */
public class CanJump {

    /**
     * 动态规划解法
     *
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return true;
        }
        boolean[] dp = new boolean[n];
        dp[0] = true;
        //dp[i]表示是否可以跳跃到位置i
        //dp[i]=  for( 0..i-1) dp[i-1]+nums[i-1]

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[j] && (j + nums[j] >= i)) {
                    dp[i] = true;
                }

            }
        }
        return dp[n - 1];
    }

    /**
     * 常规解法
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return true;
        }

        int index = n - 1;
        for (int i = index - 1; i >= 0; i--) {
            if (nums[i] + i > index) {
                index = i;
            }

        }
        return index == 0 ? true : false;
    }
}
