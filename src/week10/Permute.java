package week10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week10
 * @Description: LEECODE 46 全排列
 * @date Date : 2021年06月13日 1:11
 */
public class Permute {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        LinkedList<Integer> list = new LinkedList<>();
        boolean[] visited = new boolean[n];
        backTracking(nums, n, 0, list,visited);
        return res;
    }

    private void backTracking(int[] nums, int n, int level, LinkedList<Integer> list, boolean[] visited) {
        if (level == n) {
            res.add(new LinkedList<>(list));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            list.add(nums[i]);
            visited[i] = true;
            backTracking(nums, n, level + 1, list, visited);
            list.removeLast();
            visited[i] = false;
        }


    }
}
