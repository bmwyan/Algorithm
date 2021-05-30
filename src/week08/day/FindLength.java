package week08.day;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week08.day
 * @Description: leecode718 最长重复子数组
 * @date Date : 2021年05月30日 22:16
 */
public class FindLength {

    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];

        //dp[i][j] ：长度为i，末尾项为A[i-1]的子数组，与长度为j，末尾项为B[j-1]的子数组，二者的最大公共后缀子数组长度。
        //dp[i][j]：表示第一个数组 A 前 i 个元素和数组 B 前 j 个元素组成的最长公共子数组(相当于子串)的长度

        //转移方程
        //nums1[i]=nums2[j] dp[i][j]=dp[i-1][j-1]+1
        //nums1[i]!=nums2[j] dp[i][j]=0
        // 0 [1 2 3 2 1]
        //[3
        // 2
        // 1
        // 4
        // 7]
        int res = 0;
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                res = Math.max(dp[i][j], res);
            }

        return res;
    }
}
