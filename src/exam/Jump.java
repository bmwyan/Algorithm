package exam;

import org.junit.experimental.max.MaxHistory;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package exam
 * @Description: TODO
 * @date Date : 2021年05月04日 20:24
 */
public class Jump {

    /**
     * 贪心算法
     *
     * @param nums
     * @return
     */
    public int jump2(int[] nums) {
        int steps = 0;
        int maxPosition = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    /**
     * BFS算法求最短路径
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int step = 0;
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, nums[0]});
        visited.add(0);
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curLocation = queue.poll();
                int maxIndex = curLocation[0] + curLocation[1];
                if (maxIndex >= nums.length - 1) {
                    return step;
                }
                for (int nextIndex = curLocation[0] + 1; nextIndex <= maxIndex; nextIndex++) {
                    if (visited.contains(nextIndex)) {
                        continue;
                    }
                    queue.add(new int[]{nextIndex, nums[nextIndex]});
                    visited.add(nextIndex);
                }
            }
        }
        return 0;
    }
}
