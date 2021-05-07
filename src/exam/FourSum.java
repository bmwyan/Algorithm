package exam;


import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package exam
 * @Description: TODO
 * @date Date : 2021年05月04日 20:29
 */
public class FourSum {
    /**
     * 两头夹逼
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) {
                continue;
            }

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int start = j + 1;
                int end = n - 1;
                while (start < end) {
                    if (nums[i] + nums[j] + nums[start] + nums[end] == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        while (start < end && nums[start] == nums[++start]) ;
                        while (start < end && nums[end] == nums[--end]) ;
                    } else if (nums[i] + nums[j] + nums[start] + nums[end] - target < 0) {
                        while (start < end && nums[start] == nums[++start]) ;
                    } else {
                        while (start < end && nums[end] == nums[--end]) ;
                    }

                }
            }

        }
        return res;
    }


    /**
     * 采用SET方法判断
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                Set<Integer> set = new HashSet<>();
                int subTarget = target - (nums[i] + nums[j]);
                for (int k = j + 1; k < n; k++) {
                    int rest = subTarget - nums[k];
                    //判断rest在不在MAP中
                    if (set.contains(rest)) {
                        List<Integer> result = Arrays.asList(nums[i], nums[j], nums[k], rest);
                        result.sort(Comparator.naturalOrder());
                        res.add(result);
                    } else {
                        set.add(nums[k]);
                    }
                }
            }

        }
        return new ArrayList<>(res);
    }
}
