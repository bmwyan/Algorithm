package week04;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week04
 * @Description: leecode647. 回文子串
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * @date Date : 2021年04月21日 0:47
 */
public class PalindromicSubstring {

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int count = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        //dp[i][j]表示i和j之间的数字是否是回文串个数
        dp[0][0] = true;
        //转移方案dp[i][j]=
        char[] ss = s.toCharArray();

        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                //里面有3种情形：1）.单个字母 2）二个字母，且相同 3）3个字母

                if (ss[i] != ss[j]) {
                    continue;
                }

                dp[i][j] = (i == j) || j - i == 1 || dp[i + 1][j - 1];

                if (dp[i][j]) {
                    count++;
                }

            }
        }

        return count;
    }
}
