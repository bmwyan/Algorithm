package week09;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week09
 * @Description: leecode32 最长有效拓号
 * @date Date : 2021年06月06日 23:06
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n];
        char[] sc = s.toCharArray();
        //dp[i]表示以s.charAt(i)字符结尾的最长有效子符串长度
        //1) sc[i]=')' && sc[i-1]='('  dp[i]=dp[i-2]+2;
        //2) sc[i]=')' && sc[i-1]=')' && sc[i-dp[i-1]-1]='('
        //  dp[i]=dp[i-1]+2+dp[i-dp[i-1]-2]
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (sc[i] == ')') {
                if (sc[i - 1] == '(') {
                    dp[i] = (i - 2 >= 0) ? (dp[i - 2] + 2) : 2;
                } else {
                    if ((i - dp[i - 1] - 1 >= 0) && sc[i - dp[i - 1] - 1] == '(') {
                        // dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
                        dp[i] = dp[i - 1] + ((i - dp[i - 1] >= 2 )? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                }
                res=Math.max(res,dp[i]);
            }
        }
        return res;
    }
}
