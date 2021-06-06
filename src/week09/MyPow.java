package week09;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week09
 * @Description: leecode50 Pow(x,n)
 * @date Date : 2021年06月04日 23:17
 */
public class MyPow {
    public double myPow(double x, int n) {
        long N = n;
        if (N > 0) {
            return pow(x, N);
        } else {
            return 1.0 / pow(x, N);
        }
    }

    private double pow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }

        double y = pow(x, n / 2);
        return (n % 2 == 0) ? y * y : y * y * x;
    }


    private double pow2(double x, long n) {
        double ans = 1.0;
        double res = x;
        while (n > 0) {
            if (n % 2 == 1) {
                ans *= x;
            }
            res *= res;
            n = n / 2;

        }
        return res;
    }

}
