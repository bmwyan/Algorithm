package zniuyang.buckets;

import java.util.Arrays;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package zniuyang.backTracking
 * @Description: leecode621 任务调度器
 * @date Date : 2021年05月05日 22:15
 */
public class LeastInterval {

    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char c : tasks) {
            counts[c - 'A'] += 1;
        }

        Arrays.sort(counts);
        int maxTimes = counts[25] ;
        int i = 25;
        int maxCount = 0;
        while (i >= 0 && counts[i] == counts[25]) {
            maxCount++;
            i--;
        }
        return Math.max(tasks.length, (maxTimes - 1) * (n + 1) + maxCount);
    }

}
