package week11;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week11
 * @Description: leecode91 解码方法
 * @date Date : 2021年06月14日 18:43
 */
public class NumDecodings {

    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0 || s.startsWith("0")) {
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int a = s.charAt(i - 1) - '0';
            if (a > 0 && a <= 9) {
                dp[i] += dp[i - 1];
            }

            if (i >= 2) {
                int c = s.charAt(i - 2) - '0';
                int t = c * 10 + a;
                if (t >= 10 && t <= 26) {
                    dp[i] += dp[i - 2];
                }
            }

        }
        return dp[n];
    }
}
