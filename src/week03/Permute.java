package week03;

import java.util.*;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week03
 * @Description: leecode46 全排列
 * @date Date : 2021年04月18日 14:19
 */
public class Permute {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }

        LinkedList<Integer> list = new LinkedList<>();

        boolean[] used = new boolean[nums.length];

        backTracking(nums, 0, used, list);
        return res;
    }

    private void backTracking(int[] nums, int index, boolean[] used, LinkedList<Integer> list) {
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            used[i] = true;
            list.add(nums[i]);
            this.backTracking(nums, index + 1, used, list);
            used[i] = false;
            list.removeLast();
        }
    }

}
