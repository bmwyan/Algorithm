package week03;

import meta.TreeNode;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week03
 * @Description: leecode111
 * @date Date : 2021年04月13日 0:20
 */
public class TreeMinDepth {

    /**
     * 递归方式
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftDepth = Integer.MAX_VALUE;
        int rightDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            leftDepth = minDepth(root.left);
        }
        if (root.right != null) {
            rightDepth = minDepth(root.right);
        }

        return Math.min(leftDepth, rightDepth) + 1;
    }

    /**
     * 递归方式
     *
     * @param root
     * @return
     */
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null) {
            return minDepth2(root.right) + 1;
        } else if (root.right == null) {
            return minDepth2(root.left) + 1;
        } else {
            return Math.min(minDepth2(root.left), minDepth2(root.right)) + 1;
        }
    }
}
