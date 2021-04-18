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
        LinkedList<Integer> list = new LinkedList<>();
        int size = nums.length;
        boolean[] used = new boolean[size];
        backTracking(nums, size, 0, list, used);
        return res;
    }

    private void backTracking(int[] nums, int size, int index, LinkedList<Integer> list, boolean[] used) {
        if (index == size) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < size; i++) {
            if (used[i]) {
                continue;
            }

            list.add(nums[i]);
            used[i] = true;

            this.backTracking(nums, size, index + 1, list, used);
            list.removeLast();
            used[i] = false;
        }
    }
}
