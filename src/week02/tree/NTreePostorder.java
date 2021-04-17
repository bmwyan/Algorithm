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
 * @date Date : 2021年04月10日 23:04
 */
public class NTreePostorder {

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<Integer>();
        this.postorder(root, res);

        return res;
    }


    public void postorder(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }

        for (Node node : root.children) {
            this.postorder(node, res);
        }
        res.add(root.val);
    }
}
