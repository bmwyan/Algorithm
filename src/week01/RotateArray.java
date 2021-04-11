package week01;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week02
 * @Description: leecode189
 * @date Date : 2021年04月11日 22:28
 */
public class RotateArray {
    /**
     * 复制数组的方式
     *
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        int length = nums.length;
        int[] newArray = new int[length];

        for (int i = 0; i < length; i++) {
            int index = (i + k) % length;
            newArray[index] = nums[i];
        }
        System.arraycopy(newArray, 0, nums, 0, length);
    }


    /**
     * 就地替换
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;

        int count = 0;
        for (int start = 0; count < length; start++) {
            int cur = start;
            int pre =nums[cur];
            do {
                count++;
                int next = (cur + k) % length;
                int temp = nums[next];
                nums[next] = pre;
                pre=temp;
                cur=next;
            } while (start != cur);
        }
    }
}
