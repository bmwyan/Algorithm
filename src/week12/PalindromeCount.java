package week12;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week12
 * @Description: 求一个字符串中回文子串的个数
 * @date Date : 2021年06月23日 22:19
 */
public class PalindromeCount {

    /**
     * 从后往前
     *
     * @param s
     * @return
     */
    public int countPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;
        //dp[i][j]表示i..j的字符串是否为子序列
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j <= n - 1; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    count = dp[i][j] == true ? count + 1 : count;
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return count;
    }

    /**
     * 从前往后
     *
     * @param s
     * @return
     */
    public int countPalindrome2(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;
        //dp[i][j]表示i..j的字符串是否为子序列
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i - j < 2) {
                        dp[i][j] = true;
                        System.out.println("i=" + i + ",j=" + j);
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    count = dp[i][j] == true ? count + 1 : count;

                } else {
                    dp[i][j] = false;
                }
            }
        }
        return count;
    }


}
