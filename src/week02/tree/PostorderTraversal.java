package week02.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week02.tree
 * @Description: TODO
 * @date Date : 2021年04月10日 23:02
 */
public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        this.postorderTraversal(root, res);

        return res;
    }

    public void postorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        this.postorderTraversal(root.left, res);
        this.postorderTraversal(root.right, res);
        res.add(root.val);
    }
}
