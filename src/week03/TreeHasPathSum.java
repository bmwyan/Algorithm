package week03;

import meta.TreeNode;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week03
 * @Description: leecode112 ud给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 * @date Date : 2021年04月15日 0:00
 */
public class TreeHasPathSum {

    /**
     * 递归解法，DFS
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        boolean flag = false;
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        flag = hasPathSum(root.left, targetSum - root.val);

        if (!flag) {
            return hasPathSum(root.right, targetSum - root.val);
        }
        return flag;
    }


    /**
     * 采用回溯解法
     *
     * @param root
     * @param targetSum
     * @return
     */
    private Integer sum = 0;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        // Integer sum = 0;
        return backTrack(root, targetSum);
    }

    private boolean backTrack(TreeNode node, int targetSum) {
        if (node == null) {
            return sum == targetSum;
        }

        //此回溯不知道 咋排除另一边为空的情形
        boolean flag = false;
        sum += node.val;

        for (int i = 0; i < 2; i++) {
            TreeNode t = null;
            if (i == 0) {
                t = node.left;
            } else {
                t = node.right;
            }
            flag = backTrack(t, targetSum);

            if (flag) {
                return true;
            }

            sum -= (t != null ? t.val : 0);
        }

        return flag;
    }
}
