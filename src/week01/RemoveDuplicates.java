package week01;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week01
 * @Description: TODO
 * @date Date : 2021年04月07日 23:45
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {

        int pre = 0;
        int cur = pre + 1;
        while (cur < nums.length) {
            if (nums[pre] == nums[cur]) {
                cur++;
            } else {
                nums[++pre]=nums[cur++];
            }
        }
        return pre+1;
    }
}
