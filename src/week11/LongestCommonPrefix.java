package week11;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week11
 * @Description: leecode14 最长公共前缀
 * @date Date : 2021年06月14日 23:59
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        for (String str : strs) {
            trie.addWord(str);
        }
        StringBuilder sb = new StringBuilder();
        char[] sc = strs[0].toCharArray();
        for (int i = 0; i < sc.length; i++) {
            int index = sc[i] - 'a';
            if (trie.children[index] != null && trie.children[index].count == strs.length) {
                sb.append(sc[i]);
                trie = trie.children[index];
            } else {
                break;
            }
        }
        return sb.toString();
    }

    class Trie {
        Trie[] children;
        //当前节点计数
        int count = 0;

        public Trie() {
            children = new Trie[26];
            count = 0;
        }

        public void addWord(String words) {
            Trie trie = this;
            char[] sc = words.toCharArray();
            for (int i = 0; i < sc.length; i++) {
                int index = sc[i] - 'a';
                if (trie.children[index] == null) {
                    trie.children[index] = new Trie();
                }
                trie = trie.children[index];
                trie.count++;
            }

        }
    }

}
