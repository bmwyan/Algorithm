package exam;

import java.util.*;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package exam
 * @Description: 期末考试
 * @date Date : 2021年06月13日 23:05
 */
public class LadderLength {


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dicts = new HashSet<>(wordList);
        if (!dicts.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int count = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                char[] sc = s.toCharArray();
                for (int j = 0; j < sc.length; j++) {
                    char temp = sc[j];
                    for (int k = 0; k < 26; k++) {
                        sc[j] = (char) (k + 'a');
                        if (sc[j] == temp) {
                            continue;
                        }

                        String newWord = new String(sc);
                        if (newWord.equals(endWord)) {
                            return count;
                        }
                        if (dicts.contains(newWord)) {
                            queue.add(newWord);
                            dicts.remove(newWord);
                        }
                    }
                    sc[j] = temp;
                }

            }
        }

        return 0;
    }
}
