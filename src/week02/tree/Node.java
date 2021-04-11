package week02.tree;

import java.util.List;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week02.tree
 * @Description: TODO
 * @date Date : 2021年04月10日 23:04
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
