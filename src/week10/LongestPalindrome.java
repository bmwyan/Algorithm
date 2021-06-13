package week10;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week10
 * @Description: LEECODE5 最长回文字串
 * @date Date : 2021年06月14日 0:22
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        //dp[i][j]表示字符i..j的字符是否是回文子串
        String res = "";
        for (int i = n - 1; i >= 0; i--)
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = (j - i < 2) || dp[i + 1][j - 1];
                }
                if (dp[i][j]) {
                    if (j - i + 1 > res.length()) {
                        res = s.substring(i, j + 1);
                    }

                }
            }
        return res;
    }

}
