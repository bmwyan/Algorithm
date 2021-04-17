package week02.tree;

import meta.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week02.tree
 * @Description: TODO
 * @date Date : 2021年04月10日 23:08
 */
public class NTreePreorder {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<Integer>();
        this.preorder(root, res);

        return res;
    }


    public void preorder(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        for (Node node : root.children) {
            this.preorder(node, res);
        }

    }
}
