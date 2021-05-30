package week08.day;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week08.day
 * @Description: leecode231 2的幂
 * @date Date : 2021年05月24日 23:35
 */
public class Day50IsPowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    public boolean isPowerOfTwo2(int n) {

        return (n > 0) && (n & (n - 1)) == 0;
    }
}
