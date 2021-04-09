package week01;

import java.util.*;

public class ThreeSum {


    /**
     * 夹逼方法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[++j]) ;
                    while (j < k && nums[k] == nums[--k]) ;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    while (j < k && nums[j] == nums[++j]) ;
                } else {
                    while (j < k && nums[k] == nums[--k]) ;
                }
            }

        }
        return res;
    }

    /**
     * 采用hash方法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> list = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int target = -nums[i];
            Set<Integer> set = new HashSet<>();
            for (int j = i+1; j < nums.length; j++) {
                if (set.contains(target - nums[j])) {
                    List<Integer> l = Arrays.asList(nums[i], nums[j], target-nums[j]);
                    l.sort(Comparator.naturalOrder());
                    list.add(l);
                } else {
                    set.add(nums[j]);
                }
            }

        }


        return new ArrayList<>(list);


    }

}
