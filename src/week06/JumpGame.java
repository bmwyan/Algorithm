package week06;

import javax.swing.*;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week06
 * @Description: leecode55 跳跃游戏
 * @date Date : 2021年05月15日 12:00
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        int endIndex = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= endIndex) {
                endIndex = i;
            }

        }

        return endIndex == 0;

    }
}
