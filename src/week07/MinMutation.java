package week07;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week07
 * @Description: leecode433 最小基因变化
 * @date Date : 2021年05月21日 0:15
 */
public class MinMutation {

    public int minMutation(String start, String end, String[] bank) {
        char[] dict = new char[]{'A', 'C', 'G', 'T'};
        Set<String> set = new HashSet<>();
        for (String word : bank) {
            set.add(word);
        }
        if (!set.contains(end)) {
            return -1;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int k = 0; k < size; k++) {
                String word = queue.poll();
                char[] s = word.toCharArray();
                for (int i = 0; i < s.length; i++) {
                    char origin = s[i];
                    for (int j = 0; j < dict.length; j++) {
                        if (origin == dict[j]) {
                            continue;
                        }
                        s[i] = dict[j];
                        String newString = String.valueOf(s);

                        if(visited.contains(newString)){
                            continue;
                        }
                        visited.add(newString);
                        if (newString.equals(end)) {
                            return count;
                        } else if (set.contains(newString)) {
                            System.out.println("re:" + newString);
                            queue.add(newString);
                            set.remove(newString);
                        }
                    }
                    s[i] = origin;
                }

            }


        }
        return -1;
    }
}
