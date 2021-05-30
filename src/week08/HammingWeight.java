package week08;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week08
 * @Description: leecode191 位1的个数
 * @date Date : 2021年05月30日 23:43
 */
public class HammingWeight {

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

}
