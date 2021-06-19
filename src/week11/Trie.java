package week11;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week11
 * @Description: leecode208 Trie
 * @date Date : 2021年06月14日 23:30
 */
public class Trie {
    Trie[] children;
    boolean isLeaf = false;


    /**
     * Initialize your data structure here.
     */
    public Trie() {
        children = new Trie[26];
        isLeaf = false;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Trie trie = this;
        char[] sc = word.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            int index = sc[i] - 'a';
            if (trie.children[index] == null) {
                trie.children[index] = new Trie();
            }
            trie = trie.children[index];
        }
        trie.isLeaf = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie trie = this.searchPrefix(word);
        return trie != null && trie.isLeaf == true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public Trie searchPrefix(String prefix) {
        Trie trie = this;
        char[] pc = prefix.toCharArray();
        for (int i = 0; i < pc.length; i++) {
            int index = pc[i] - 'a';
            if (trie.children[index] != null) {
                trie = trie.children[index];
            } else {
                return null;
            }

        }
        return trie;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie trie = this.searchPrefix(prefix);
        return trie != null;
    }
}
