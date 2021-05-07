package week05.binarysearch;

import java.awt.datatransfer.FlavorEvent;
import java.lang.reflect.Array;
import java.util.*;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week05
 * @Description: leecode126 单词接龙II
 * @date Date : 2021年05月01日 10:34
 */
public class FindLadders {

    private List<List<String>> res = new ArrayList<>();
    private Set<String> dict = new HashSet<>();
    private boolean isFound = false;
    private Map<String, Integer> steps = new HashMap<>();
    private Map<String, Set<String>> from = new HashMap<>();


    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        dict.addAll(wordList);
        if (dict.contains(endWord)) {
            //BFS 进行
            bfs(beginWord, endWord);
            if (isFound) {
                LinkedList<String> list = new LinkedList<>();
                list.add(endWord);
                backTracking(beginWord, endWord, list);
            }
        }
        return res;
    }

    private void backTracking(String beginWord, String endWord, LinkedList<String> list) {
        if (endWord.equals(beginWord)) {
            res.add(new ArrayList<>(list));
            return;
        }

        Set<String> froms = from.get(endWord);
        for (String from : froms) {
            list.addFirst(from);
            this.backTracking(beginWord, from, list);
            list.removeFirst();
        }
    }

    private void bfs(String beginWord, String endWord) {
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                String curr = queue.poll();
                char[] sc = curr.toCharArray();
                for (int i = 0; i < sc.length; i++) {
                    char origin = sc[i];
                    for (int j = 0; j < 26; j++) {
                        sc[i] = (char) ('a' + j);
                        String nextWord = String.valueOf(sc);

                        if (steps.containsKey(nextWord) && steps.get(nextWord) == step) {
                            from.get(nextWord).add(curr);
                        }
                        if (!dict.contains(nextWord)) {
                            continue;
                        }
                        steps.put(nextWord, step);
                        from.putIfAbsent(nextWord, new HashSet<>());
                        from.get(nextWord).add(curr);
                        dict.remove(nextWord);
                        queue.add(nextWord);

                        if (nextWord.equals(endWord)) {
                            isFound = true;

                        }

                    }
                    sc[i] = origin;
                }


            }
        }

    }
}

