package week02;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week02
 * @Description: leecode264
 * @date Date : 2021年04月10日 18:49
 */
public class UglyNumber {

    /**
     * 动态规划做法
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int a = 1, b = 1, c = 1;

        for (int i = 1; i <= n; i++) {
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2) {
                a++;
            }
            if (dp[i] == n3) {
                b++;
            }
            if (dp[i] == n5) {
                c++;
            }

        }
        return dp[n];
    }

    /**
     * 优先级队列做法
     *
     * @param n
     * @return
     */
    public int nthUglyNumber2(int n) {
        int[] factors = new int[]{2, 3, 5};
        int uglyNum = 0;
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.add(1L);
        set.add(1L);
        for (int i = 0; i < n; i++) {
            long cur = queue.poll();
            uglyNum = (int) cur;
            for (int factor : factors) {
                long nextNum = cur * factor;
                if (!set.contains(nextNum)) {
                    queue.add(nextNum);
                    set.add(nextNum);
                }
            }
        }
        return uglyNum;
    }

}
