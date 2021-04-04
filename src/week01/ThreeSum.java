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
            if (i >= 1 && nums[i - 1] == nums[i]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int temp = nums[i] + nums[j] + nums[k];
                if (temp < 0) {
                    while (j < k && nums[j] == nums[++j]) ;
                } else if (temp > 0) {
                    while (j < k && nums[k] == nums[--k]) ;
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[++j]) ;
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
        Set<List<Integer>> res = new LinkedHashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int target = -nums[i];
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsKey(target - nums[j])) {
                    List<Integer> list = Arrays.asList(nums[i], nums[j],target - nums[j]);
                    list.sort(Comparator.naturalOrder());
                     res.add(list);
                } else {
                    map.put(nums[j], nums[j]);
                }
            }
        }
        return new ArrayList<>(res);
    }

}
