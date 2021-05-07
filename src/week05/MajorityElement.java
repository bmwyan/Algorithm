package week05;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week05
 * @Description: leecode169 多数元素
 * @date Date : 2021年04月27日 23:13
 */
public class MajorityElement {

    /**
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = map.getOrDefault(nums[i], 0) + 1;
            if (value > nums.length / 2) {
                return nums[i];
            }
            map.put(nums[i], value);
        }

        return res;
    }

    /**
     * @param nums
     * @return
     */
    public int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


    /**
     * 摩尔选票法:遇到两个投票相同+1，不同减1,需要超过一半
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
            }
            count += (nums[i] == candidate) ? 1 : -1;
        }
        return candidate;
    }


}
