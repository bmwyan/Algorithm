package zniuyang.dfs;

import meta.TreeNode;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package zniuyang.dfs
 * @Description: leecode124二叉树中的最大路径和
 * @date Date : 2021年05月03日 18:28
 */
public class MaxPathSum {

    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root != null) {
            dfs(root);
        }

        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftValue = Math.max(0, dfs(root.left));
        int rightValue = Math.max(0, dfs(root.right));
        res = Math.max(leftValue + root.val + rightValue, res);
        return root.val+Math.max(leftValue,rightValue);
    }

}
