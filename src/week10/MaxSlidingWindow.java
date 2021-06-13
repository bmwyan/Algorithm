package week10;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week10
 * @Description: LEECODE239 滑动窗口最大值
 * @date Date : 2021年06月13日 13:08
 */
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        //双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int left = 0;
        for (int i = 0; i < nums.length; i++) {

            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.removeLast();
            }
            queue.addLast(i);
            left = i - k + 1;
            //窗口形成
            if (queue.peekFirst() < left) {
                queue.removeFirst();
            }

            if (left >= 0) {
                res[left] = nums[queue.peekFirst()];
            }
        }
        return res;
    }
}
