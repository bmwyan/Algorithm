package week12;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week12
 * @Description: LEECODE1043 分隔数组以得到最大和
 * @date Date : 2021年06月27日 22:50
 */
public class MaxSumAfterPartitioning {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int sum = 0;
        int n = arr.length;
        int[] dp = new int[n + 1];
        //dp[i]表示以arr[i]结尾数组的前 i 个数即 nums[0,1...i-1],被切了 Y-1刀，分割成 Y个数组，
        // 满足每个数组的个数最大值不超过 K，每个数组的值变成最大值，分割后的最大和
        //dp[i]=max(dp[i-j]+j*max)

        //转移方程
        for (int i = 0; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    max = Math.max(max, arr[i - j]);
                    dp[i] = Math.max(dp[i], dp[i - j] + (j) * max);
                }
            }
        }
        return dp[n];
    }


    public int maxSumAfterPartitioning2(int[] arr, int k) {
        int sum = 0;
        int n = arr.length;
        int[] dp = new int[n + 1];
        //dp[i]表示以arr[i]结尾数组的前 i 个数即 nums[0,1...i-1],被切了 Y-1刀，分割成 Y个数组，
        // 满足每个数组的个数最大值不超过 K，每个数组的值变成最大值，分割后的最大和

        //转移方程
        for (int i = 0; i <= n; i++) {
            int j = i - 1;
            int max = 0;
            while (j >= 0 && (i - j) <= k) {
                max = Math.max(max, arr[j]);
                dp[i] = Math.max(dp[i], dp[j] + (i - j) * max);
                j--;
            }

        }

        return dp[n];
    }
}
