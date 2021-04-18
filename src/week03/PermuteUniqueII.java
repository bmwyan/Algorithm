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
        int size = nums.length;
        LinkedList<Integer> list = new LinkedList<>();
        boolean[] used = new boolean[size];

        backTracking(nums, 0, list, used);

        return res;
    }

    private void backTracking(int[] nums, int depth, LinkedList<Integer> list, boolean[] used) {

        if (depth == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            list.add(nums[i]);
            used[i] = true;
            backTracking(nums, depth + 1, list, used);
            list.removeLast();
            used[i] = false;
            while (i < (nums.length - 1) && nums[i] == nums[i + 1]) {
                i++;
            }
        }

    }
}
