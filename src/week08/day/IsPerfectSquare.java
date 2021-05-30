package week08.day;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week08.day
 * @Description: leecode367 有效的完全平方数
 * @date Date : 2021年05月25日 23:23
 */
public class IsPerfectSquare {
    public boolean isPerfectSquare(int num) {
        long left = 1, right = num;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid > num) {
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
