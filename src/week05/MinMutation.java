package week05;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week05
 * @Description: leecode 433 最小基因变化
 * @date Date : 2021年05月01日 18:11
 */
public class MinMutation {

    public int minMutation(String start, String end, String[] bank) {
        char[] replaces = {'A', 'C', 'G', 'T'};
        Set<String> set = new HashSet<>();
        for (String one : bank) {
            set.add(one);
        }
        if (!set.contains(end)) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                String mutation = queue.poll();
                char[] src = mutation.toCharArray();
                for (int i = 0; i < src.length; i++) {
                    char origin = src[i];
                    for (int j = 0; j < replaces.length; j++) {
                        if (src[i] == replaces[j]) continue;
                        src[i] = replaces[j];
                        String newStr = String.valueOf(src);
                        if (newStr.equals(end)) {
                            return level;
                        }

                        if (set.contains(newStr)) {
                            queue.add(newStr);
                            set.remove(newStr);
                        }

                    }
                    src[i] = origin;
                }
            }
        }
        return -1;
    }


}
