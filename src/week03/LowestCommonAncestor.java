package week03;

import meta.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week03
 * @Description: Leecode236 二叉树的最近公共祖先
 * @date Date : 2021年04月14日 23:27
 */
public class LowestCommonAncestor {


    /**
     * 采用递归解法
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //递归终止找条：在树中找到了P或Q
        if (root == p || root == q || root == null) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //左子树没有找到地应的节点，则取右子树的结果，包括右子树为NULL
        if (left == null) {
            return right;
        }
        //右子树没有找到地应的节点，则取左子树的结果，包括左子树为NULL
        if (right == null) {
            return left;
        }
        //两者不为空的时，说明P和Q分列在树的两边
        return root;
    }


    /**
     * 存储父节点的方式
     * 1.先存取每个节点对应的父节点，存取所有节点的父节点信息
     * 2、找出P节点的所有祖先节点列表A中
     * 3.q节点依次往上找，如果q的父节点在A中，第一个找到的就是最近的祖先
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    //所有节点对应的父节点
    private Map<Integer, TreeNode> parentMap = new HashMap<>();

    //P节点的所有祖先节点
    private Set<TreeNode> pParent = new HashSet<>();

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

        //递归终止找条：在树中找到了P或Q
        if (root == p || root == q || root == null) {
            return root;
        }
        dfs(root);

        // 需要注意将P自己包含进去
        while (p != null) {
            pParent.add(p);
            p = parentMap.get(p.val);
        }

        while (q != null) {
            if (pParent.contains(q)) {
                return q;
            }
            q = parentMap.get(q.val);
        }

        return null;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            parentMap.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parentMap.put(root.right.val, root);
            dfs(root.right);
        }
    }
}
