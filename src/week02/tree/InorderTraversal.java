package week02.tree;

import week02.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week02
 * @Description: TODO
 * @date Date : 2021年04月10日 22:50
 */
public class InorderTraversal {
    /**
     * 递归方式一，结果没有传入
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null){
            return res;
        }

        if (root.left == null && root.right == null) {
            res.add(root.val);
            return res;
        }

        List<Integer> l1 = this.inorderTraversal(root.left);
        res.addAll(l1);
        res.add(root.val);

        List<Integer> l2 = this.inorderTraversal(root.right);
        res.addAll(l2);

        return res;
    }

    /**
     * 递归方式一，结果没有传入
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        this.inorderTraversal(root,res);

        return res;
    }

    public void inorderTraversal(TreeNode root,List<Integer> res)
    {
        if(root==null)
        {
            return ;
        }
        this.inorderTraversal(root.left,res);
        res.add(root.val);
        this.inorderTraversal(root.right,res);
    }
}
