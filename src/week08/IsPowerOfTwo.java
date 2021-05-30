package week08;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week08
 * @Description: leecode 231 2的幂次方
 * @date Date : 2021年05月31日 0:15
 */
public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return (n > 0) && (n & (n - 1)) == 0;
    }

}
