package week06;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week06
 * @Description: leecode91. 解码方法
 * @date Date : 2021年05月16日 13:25
 */
public class NumDecodings {

    public int numDecodings(String s) {
        if (s.startsWith("0")) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        //dp[i]表示1..i个字符的解码方法数
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            int a = s.charAt(i - 1) - '0';
            if (a > 0 && a <= 9) {
                dp[i] += dp[i - 1];
            }
            if (i >= 2) {
                int num = (s.charAt(i - 2) - '0') * 10 + a;
                if (num >= 10 && num <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[n];
    }
}
