package week04;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week04
 * @Description: leecode55 跳跃游戏
 * @date Date : 2021年04月26日 0:41
 */
public class CanJump {


    public boolean canJump(int[] nums) {
        int endIndex = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= endIndex) {
                endIndex = i;
            }
        }

        return endIndex==0;
    }

    /**
     * 采用BFS，74/75个用例通过，还有1个超出时间限制
     *
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {
        if (nums.length == 0) {
            return true;
        }

        //int steps = 0;
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(new int[]{0, nums[0]});
        visited.add(0);
        while (!queue.isEmpty()) {
            //steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curLocation = queue.poll();
                int curIndex = curLocation[0];
                //把能跳跃到的加入到邻居当中
                int maxIndex = curLocation[0] + curLocation[1];
                if (maxIndex >= nums.length - 1) {
                    return true;
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

        return false;
    }

    /**
     * 采用回溯解决，74/75个用例通过，还有1个超出时间限制
     *
     * @param nums
     * @return
     */
    public boolean canJump3(int[] nums) {
        return this.backTracking(nums, 0);
    }

    private boolean backTracking(int[] nums, int index) {
        if (index >= nums.length - 1) {
            return true;
        }

        boolean flag = true;
        int steps = nums[index];
        for (int i = 1; i <= steps; i++) {
            int nextstep = index + i;
            flag = backTracking(nums, nextstep);
            if (flag) {
                return flag;
            }
            nextstep = index - i;
        }
        return flag;
    }

}
