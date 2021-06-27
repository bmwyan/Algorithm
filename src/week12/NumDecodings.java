package week12;

import java.util.Arrays;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week12
 * @Description: leecode91 解码方法
 * @date Date : 2021年06月24日 23:25
 */
public class NumDecodings {

    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0 || s.startsWith("0")) {
            return 0;
        }
        int[] dp = new int[n + 1];
        //dp[i]表示 0..i的解码方法
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int a = s.charAt(i - 1) - '0';
            if (a > 0 && a <= 9) {
                dp[i] += dp[i - 1];
            }
            if (i >= 2) {
                int b = s.charAt(i - 2) - '0';
                int su = b * 10 + a;
                if (su >= 10 && su <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }

        return dp[n];
    }


}
