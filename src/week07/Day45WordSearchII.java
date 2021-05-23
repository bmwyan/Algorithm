package week07;

import java.util.*;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week07
 * @Description: leecode212 单词搜索II
 * @date Date : 2021年05月23日 13:39
 */
public class Day45WordSearchII {
    private int[] directins = {-1, 0, 1, 0, -1};
    List<String> res = new ArrayList<>();

    class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        String word = null;

        public TrieNode() {
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> dicts = new HashSet<>(Arrays.asList(words));
        int m = board.length, n = board[0].length;

        //构建字典树
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (Character c : word.toCharArray()) {
                if (node.children.containsKey(c)) {
                    node = node.children.get(c);
                } else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(c, newNode);
                    node = newNode;
                }
            }
            node.word = word;
        }

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (root.children.containsKey(board[i][j])) {
                    backTracking(board, i, j, root);
                }
            }
        return res;
    }

    private void backTracking(char[][] board, int i, int j, TrieNode parent) {
        Character c = board[i][j];
        TrieNode curNode = parent.children.get(c);
        if (curNode.word != null) {
            res.add(curNode.word);
            curNode.word = null;
            parent.children.remove(c);
            return;
        }

        board[i][j] = '#';
        for (int k = 0; k < 4; k++) {
            int x = i + directins[k];
            int y = j + directins[k + 1];
            if (!isValid(board, x, y)) {
                continue;
            }
            if (curNode.children.containsKey(board[x][y])) {
                backTracking(board, x, y, curNode);
            }
        }
        board[i][j] = c;

//        if (curNode.children.isEmpty()) {
//            parent.children.remove(c);
//        }

    }

    private boolean isValid(char[][] board, int i, int j) {
        int m = board.length, n = board[0].length;
        return i >= 0 && i < m && j >= 0 && j < n;

    }


}
