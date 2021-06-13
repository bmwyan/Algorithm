package week10;

import java.util.LinkedList;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week10
 * @Description: leecode239滑动窗口最大值
 * @date Date : 2021年06月13日 13:52
 */
public class MaxSlidingWindow2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[i] > queue.peekLast()) {
                queue.removeLast();
            }
            queue.add(nums[i]);
        }
        int index = 0;
        res[index++] = queue.peekFirst();
        int left = 0;

        for (int j = k; j < nums.length; j++) {
            //窗口满了，需要移除先前的值
            if (nums[j - k] == queue.peekFirst()) {
                queue.removeFirst();
            }

            while (!queue.isEmpty() && nums[j] > queue.peekLast()) {
                queue.removeLast();
            }
            queue.add(nums[j]);

            res[index++] = queue.peekFirst();
        }
        return res;
    }
}
