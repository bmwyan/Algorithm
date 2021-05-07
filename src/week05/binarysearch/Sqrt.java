package week05.binarysearch;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week05
 * @Description: leecode69 x的平方根
 * @date Date : 2021年05月01日 19:17
 */
public class Sqrt {

    /**
     * 二分查找
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        long left = 1, right = x;
        long mid = 1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int) right;
    }

    /**
     * 牛顿迭代法
     * @param x
     * @return
     */
    public int mySqrt2(int x) {
        long r=x;
        while(r*r>x)
        {
            r=(r+x/r)/2;
        }

        return (int) r;
    }

}
