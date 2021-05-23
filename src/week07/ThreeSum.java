package week07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week07
 * @Description: 1eecode15 三数之和
 * @date Date : 2021年05月22日 13:07
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if(nums[i]>0){
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            while (j < k) {

                int a = nums[i] + nums[j] + nums[k];
                if (a == 0) {
                    List<Integer> list = Arrays.asList(new Integer[]{nums[i], nums[j], nums[k]});
                    while (j < k && nums[j] == nums[++j]) ;
                    while (j < k && nums[k] == nums[--k]) ;
                    res.add(list);
                } else if (a < 0) {
                    while (j < k && nums[j] == nums[++j]) ;
                } else {
                    while (j < k && nums[k] == nums[--k]) ;
                }
            }

        }
        return res;
    }
}
