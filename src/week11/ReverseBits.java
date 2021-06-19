package week11;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week11
 * @Description: leecode190 颠倒二进制位
 * @date Date : 2021年06月15日 21:24
 */
public class ReverseBits {

    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32; i++) {
            rev |= (n & 1) << (31 - i);
            n>>>=1;
        }
        return rev;
    }

}
