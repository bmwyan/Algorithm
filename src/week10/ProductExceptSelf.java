package week10;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week10
 * @Description: LEECODE238 除自身以外数组的乘积
 * @date Date : 2021年06月13日 0:11
 */
public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int k = 1;
        //左边的乘积
        for (int i = 0; i < n; i++) {
            res[i] = k;
            k = k * nums[i];
        }
        k = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = k * res[i];
            k = k * nums[i];
        }

        return res;

    }

}
