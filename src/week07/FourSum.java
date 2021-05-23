package week07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week07
 * @Description: leecode18 四数之和
 * @date Date : 2021年05月22日 13:35
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n=nums.length-1;
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target){
                break;
            }
            if(nums[n]+nums[n-1]+nums[n-2]+nums[n-3]<target){
                break;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int start = j + 1;
                int end = nums.length - 1;
                while (start < end) {
                    int sum = nums[i] + nums[j] + nums[start] + nums[end] - target;
                    if (sum == 0) {
                        res.add(Arrays.asList(new Integer[]{nums[i], nums[j], nums[start], nums[end]}));
                        while (start < end && nums[start] == nums[++start]) ;
                        while (start < end && nums[end] == nums[--end]) ;
                    } else if (sum < 0) {
                        while (start < end && nums[start] == nums[++start]) ;
                    } else {
                        while (start < end && nums[end] == nums[--end]) ;
                    }
                }
            }
        }

        return res;

    }
}
