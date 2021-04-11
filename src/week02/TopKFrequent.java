package week02;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week02
 * @Description: TODO
 * @date Date : 2021年04月11日 14:43
 */
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length <= k) {
            return nums;
        }
        int[] res = new int[k];
        Map<Integer, Integer> cMap = new HashMap<>();
        for (int num : nums) {
            cMap.put(num, cMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((o1, o2) -> (o2[1] - o1[1]));

        for (Map.Entry<Integer, Integer> entry : cMap.entrySet()) {
            queue.add(new int[]{entry.getKey(), entry.getValue()});
        }
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }

        return res;
    }
}
