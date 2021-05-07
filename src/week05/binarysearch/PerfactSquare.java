package week05.binarysearch;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week05
 * @Description: leecode367有效的完全平方数
 * @date Date : 2021年05月01日 23:29
 */
public class PerfactSquare {
    public boolean isPerfectSquare(int num) {
        boolean flag = false;
        long left = 1, right = num;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
