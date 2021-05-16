package week06;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week06
 * @Description: TODO
 * @date Date : 2021年05月15日 12:12
 */
public class JumpGameII {

    public int jump(int[] nums) {
        int steps = 0, end = 0, maxPositions = 0;
        //走到倒数第2步就可以了,因为第1跳已经算一步了
        for (int i = 0; i < nums.length - 1; i++) {
            maxPositions = Math.max(maxPositions, i + nums[i]);
            if (i == end) {
                steps++;
                end = maxPositions;
            }

        }

        return steps;
    }


}
