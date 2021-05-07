package zniuyang.backTracking;

import java.util.*;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package zniuyang.dfs
 * @Description: leecode332 重新安排行程
 * @date Date : 2021年05月04日 0:36
 */
public class FindItineraryBackTracking {

    private LinkedList<String> res = new LinkedList<>();
    private Map<String, TreeMap<String, Integer>> map = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> pair : tickets) {
            String from = pair.get(0);
            String to = pair.get(1);
            map.putIfAbsent(from, new TreeMap<String, Integer>());
            TreeMap<String, Integer> temp = map.get(from);
            temp.put(to, temp.getOrDefault(to, 0) + 1);
        }

        res.add("JFK");
        int size = tickets.size() + 1;
        backTracking("JFK", size);

        return res;
    }

    private boolean backTracking(String from, int size) {
        if (res.size() == size) {
            return true;
        }
        TreeMap<String, Integer> tree = map.get(from);
        if (tree == null) {
            return false;
        }

        for (Map.Entry<String, Integer> entry : tree.entrySet()) {
            String to = entry.getKey();
            Integer count = entry.getValue();
            if (count > 0) {
                res.add(to);
                entry.setValue(count - 1);
                if (backTracking(to, size)) {
                    return true;
                }

                res.removeLast();
                entry.setValue(count);
            }
        }
        return false;
    }
}
