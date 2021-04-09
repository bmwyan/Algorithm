package week02;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week02
 * @Description: TODO
 * @date Date : 2021年04月08日 23:42
 */
public class MaxSlidingWindow {
    /**
     * 超出版本时间复杂度
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> (o2 - o1)));
        int[] res = new int[nums.length - k + 1];

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (queue.size() % k == 0) {
                //获取最大值
                res[index++] = queue.peek();
                queue.remove(nums[i + 1 - k]);
            }
        }

        return res;
    }


    /**
     * https://leetcode-cn.com/problems/sliding-window-maximum/solution/zhe-hui-yi-miao-dong-bu-liao-liao-de-hua-7fy5/
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int index = 0;

        LinkedList<Integer> queue = new LinkedList<>();
        //窗口形成
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[i] > queue.peekLast()) {
                queue.removeLast();
            }
            queue.add(nums[i]);
        }
        res[index++] = queue.peekFirst();
        for (int j = k; j < nums.length; j++) {
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


    /**
     * https://leetcode-cn.com/problems/sliding-window-maximum/solution/dong-hua-yan-shi-dan-diao-dui-lie-239hua-hc5u/
     * 高效解法
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow3(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
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
            if (i+1>=k) {
                res[left] = nums[queue.peekFirst()];
            }

        }
        return res;
    }
}
