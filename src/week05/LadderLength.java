package week05;

import java.util.*;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week05
 * @Description: leecode127 单词接龙
 * @date Date : 2021年04月28日 22:17
 */
public class LadderLength {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int res = 0;
        if (wordList.contains(endWord)) {
            res = bfs(beginWord, endWord, wordList);

        }
        return res;
    }

    private int bfs(String beginWord, String endWord, List<String> wordList) {
        Set<String> allSet = new HashSet<>();
        allSet.addAll(wordList);
        Set<String> visited = new HashSet<>();
        int level = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return level;
                }
                char[] cc = word.toCharArray();
                for (int j = 0; j < cc.length; j++) {
                    char pre = cc[j];
                    for (int k = 0; k < 26; k++) {
                        cc[j] = (char) ('a' + k);
                        String newWord = String.valueOf(cc);
                        if (allSet.contains(newWord) && visited.add(newWord)) {
                            queue.add(newWord);
                        }
                    }
                    cc[j] = pre;
                }
            }
        }
        return 0;
    }
}
