package week06;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week06
 * @Description: leecode70 爬楼梯
 * @date Date : 2021年05月09日 22:30
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        if (n < 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];

        }
        return dp[n];
    }
}
