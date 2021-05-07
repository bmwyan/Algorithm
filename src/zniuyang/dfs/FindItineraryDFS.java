package zniuyang.dfs;

import java.nio.channels.Pipe;
import java.util.*;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package zniuyang.dfs
 * @Description: leecode332 重新安排行程
 * @date Date : 2021年05月03日 22:36
 */
public class FindItineraryDFS {

    private LinkedList<String> res = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets == null || tickets.isEmpty()) {
            return res;
        }
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> pair : tickets) {
            String from = pair.get(0);
            String to = pair.get(1);
            map.putIfAbsent(from, new PriorityQueue<String>());
            map.get(from).add(to);
        }


        dfs(map, "JFK");
        return res;
    }

    private void dfs(Map<String, PriorityQueue<String>> map, String from) {
        PriorityQueue<String> queue = map.get(from);
        while (queue != null && !queue.isEmpty()) {
            String to = queue.poll();
            dfs(map, to);
        }
        res.addFirst(from);
    }

}
