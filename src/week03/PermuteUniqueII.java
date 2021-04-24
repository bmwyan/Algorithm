package week03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week03
 * @Description: leecode47 全排列，数字有可能重复
 * @date Date : 2021年04月18日 15:30
 */
public class PermuteUniqueII {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        LinkedList<Integer> list = new LinkedList<>();

        boolean[] used = new boolean[nums.length];
        backTracking(nums, 0, used, list);

        return res;
    }

    private void backTracking(int[] nums, int depth, boolean[] used, LinkedList<Integer> list) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i]) {
                continue;
            }

            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }

            list.add(nums[i]);
            used[i] = true;
            this.backTracking(nums, depth + 1, used, list);
            used[i] = false;
            list.removeLast();
//            while (i < nums.length - 1) {
//                if (nums[i] == nums[i + 1]) {
//                    i++;
//                } else {
//                    break;
//                }
//            }

        }
    }

}
