package week10;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week10
 * @Description: leecode 239滑动窗口最大值
 * @date Date : 2021年06月13日 14:04
 */
public class MaxSlidingWindow3 {
    /**
     * 优先级队列解法，耗时比较长
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];

        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? (o2[0] - o1[0]) : (o2[1] - o1[1]);
            }
        });

        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{nums[i], i});
        }
        int index = 0;
        res[index++] = queue.peek()[0];
        for (int j = k; j < nums.length; j++) {

            queue.offer(new int[]{nums[j], j});
            while (queue.peek()[1] <= j - k) {
                queue.poll();
            }
            res[index++] = queue.peek()[0];
        }
        return res;
    }
}
