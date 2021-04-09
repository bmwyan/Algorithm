package week02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week02
 * @Description: TODO
 * @date Date : 2021年04月07日 22:11
 */
public class Intersect {

    /**
     * 采用hash的方式
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            return this.intersect(nums2, nums1);
        }

        Map<Integer, Integer> num1Map = new HashMap<>();
        for (int num1 : nums1) {
            num1Map.put(num1, num1Map.getOrDefault(num1, 0) + 1);
        }
        int[] res = new int[nums2.length];
        int index = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (num1Map.containsKey(nums2[i])) {
                res[index++] = nums2[i];

                int temp = num1Map.get(nums2[i]) - 1;
                if (temp > 0) {
                    num1Map.put(nums2[i], temp);

                } else {
                    num1Map.remove(nums2[i]);
                }

            }
        }

        return Arrays.copyOfRange(res, 0, index);
    }

    /**
     * 采用双指针的方式
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int s = Math.min(nums1.length, nums2.length);
        int p1 = 0;
        int p2 = 0;
        int[] res = new int[s];
        int index = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] > nums2[p2]) {
                p2++;
            } else if (nums1[p1] < nums2[p2]) {
                p1++;
            } else {
                res[index++] = nums1[p1];
                p1++;
                p2++;
            }
        }
        return Arrays.copyOfRange(res, 0, index);
    }
}
