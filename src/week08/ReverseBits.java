package week08;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week08
 * @Description: leecode190 颠倒二进制位
 * @date Date : 2021年05月31日 0:05
 */
public class ReverseBits {
    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32; i++) {
            rev |= (n & 1) << (32 - i);
            //无符号右移，符号位补0
            n >>>= 1;
        }
        return rev;
    }

}
