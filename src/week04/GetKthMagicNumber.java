package week04;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week04
 * @Description: 第 k 个数
 * @date Date : 2021年04月21日 0:26
 */
public class GetKthMagicNumber {

    /*
    有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。

    示例 1:

    输入: k = 5

    输出: 9

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/get-kth-magic-number-lcci
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

     */

    public int getKthMagicNumber(int k) {
        int[] dp = new int[k + 1];
        dp[1] = 1;
        int i3 = 1, i5 = 1, i7 = 1;

        for (int i = 2; i <= k; i++) {
            int n3 = dp[i3] * 3;
            int n5 = dp[i5] * 5;
            int n7 = dp[i7] * 7;
            dp[i] = Math.min(Math.min(n3, n5), n7);
            if (dp[i] == n3) i3++;
            if (dp[i] == n5) i5++;
            if (dp[i] == n7) i7++;
        }

        return dp[k];
    }
}
