package week06;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week05
 * @Description: LEECODE45 跳跃游戏 II
 * @date Date : 2021年05月03日 12:39
 */
public class JumpII {
    /**
     * 贪心算法
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        //maxPosition表示可以到达最远的位置
        int steps = 0, end = 0, maxPosition = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }


    /**
     * BFS解法
     *
     * @param nums
     * @return
     */
    public int jump2(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int steps = 0;
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(new int[]{0, nums[0]});
        visited.add(0);
        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curLocation = queue.poll();
                int curIndex = curLocation[0];
                //把能跳跃到的加入到邻居当中
                int maxIndex = curLocation[0] + curLocation[1];
                if (maxIndex >= nums.length - 1) {
                    return steps;
                }
                int nextIndex = curIndex + 1;
                while (nextIndex <= maxIndex) {
                    if (!visited.contains(nextIndex)) {
                        visited.add(nextIndex);
                        queue.add(new int[]{nextIndex, nums[nextIndex]});
                    }
                    nextIndex++;
                }
            }
        }

        return 0;
    }


}
