package week11;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week11
 * @Description: TODO
 * @date Date : 2021年06月19日 23:12
 */
public class Fib {
    public int fib(int n) {
        int[] mem = new int[n ];
        int res = fibSub(n, mem);
        return res;
    }

    private int fibSub(int n, int[] mem) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (mem[n-1] != 0) {
            return mem[n-1];
        }

        mem[n-1] = (fibSub(n - 1, mem) + fibSub(n - 2, mem)) % 1000000007;

        return mem[n-1];
    }
}
