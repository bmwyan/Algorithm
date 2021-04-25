package week04;

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

        boolean flag = backTracking(nums, 0);
        return flag;

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
