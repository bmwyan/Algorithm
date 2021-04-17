package week02.tree;

import meta.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week02
 * @Description: TODO
 * @date Date : 2021年04月10日 22:59
 */
public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        this.preorderTraversal(root, res);

        return res;
    }


    public void preorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        this.preorderTraversal(root.left, res);
        this.preorderTraversal(root.right, res);
    }
}
