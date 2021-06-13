package exam;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package exam
 * @Description: 期末考试题
 * @date Date : 2021年06月13日 22:13
 */
public class NumDecodings {

    public int numDecodings(String s) {
        if (s.startsWith("0")) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        char[] sc = s.toCharArray();
        for (int i = 1; i < n; i++) {
            int a = sc[i - 1] - '0';
            if (a >= 1 && a <= 9) {
                dp[i] += dp[i - 1];
            }

            if (i >= 2) {
                int b = sc[i - 1] - '0';
                int c = b * 10 + a;
                if (c >= 10 && c <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[n];
    }


    public int numDecodings2(String s) {
        int n = s.length();
        if (n == 0 || s.startsWith("0")) {
            return 0;
        }
        char[] sc = s.toCharArray();
        if (n <= 1) {
            return 1;
        }


        int[] dp = new int[n];
        //dp[i]表示以i结尾的编码数
        //转移方程：[12][0-6]   || [0][1-9] || [3-9]
        //1）如果sc[i-1]=
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int pre = sc[i - 1] - '0';
            int cur = sc[i] - '0';
            if (cur == 0) {
                if (pre == 0 || pre >= 3) {
                    return 0;
                } else if (pre >= 1 && pre <= 2) {
                    dp[i] = (i >= 2 ? dp[i - 2] : 1);
                }
            } else if (cur >= 1 && cur <= 6) {
                if (pre >= 1 && pre <= 2) {
                    dp[i] = dp[i - 1] + (i >= 2 ? dp[i - 2] : 1);
                } else {
                    dp[i] = dp[i - 1];
                }
            } else {
                dp[i] = dp[i - 1];
            }

        }
        return dp[n - 1];
    }
}
