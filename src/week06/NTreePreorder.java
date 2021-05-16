package week06;

import meta.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week06
 * @Description: leecode589 N叉树前序遍历
 * @date Date : 2021年05月13日 23:30
 */
public class NTreePreorder {

    private List<Integer> res = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return res;
        }
        res.add(root.val);
        List<Node> childrens = root.children;
        for (Node child : childrens) {
            preorder(child);
        }
        return res;
    }
}
