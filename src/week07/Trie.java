package week07;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week07
 * @Description: leecode208 实现前缀树
 * @date Date : 2021年05月18日 23:19
 */
public class Trie {
    private Trie[] childrens;
    boolean isEnd;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        childrens = new Trie[26];
        isEnd = false;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Trie trie = this;
        for (int i = 0; i < word.length(); i++) {
            char s = word.charAt(i);
            int index = s - 'a';
            if (trie.childrens[index] == null) {
                trie.childrens[index] = new Trie();
            }
            trie = trie.childrens[index];
        }
        trie.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie trie = searchPrefix(word);
        return trie != null && trie.isEnd == true;
    }


    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }


    private Trie searchPrefix(String prefix) {
        Trie trie = this;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (trie.childrens[index] != null) {
                trie = trie.childrens[index];
            } else {
                return null;
            }
        }
        return trie;
    }
}
