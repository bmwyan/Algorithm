package week12;

import java.util.Arrays;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week12
 * @Description: TODO
 * @date Date : 2021年06月27日 22:01
 */
public class FindNumberOfLIS {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        //dp[i] 以nums[i]结束的递增序列的最大长度
        Arrays.fill(dp,1);
        int[] count = new int[n];
        Arrays.fill(count,1);
        // count[i] 以nums[i]结束的最长递增子序列的个数
        int maxLength = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (nums[i] > nums[j]) {

                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i]=count[j];
                        maxLength=Math.max(maxLength,dp[i]);
                    }else if(dp[j]+1==dp[i]){
                        count[i]+=count[j];
                    }
                }
            }
        }
        int sum=0;
        for(int i=0;i<n;i++){
            if(maxLength==dp[i]){
                sum+=count[i];
            }
        }
        return sum;
    }
}
