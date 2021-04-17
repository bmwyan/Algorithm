package week03;

import meta.TreeNode;

import java.util.LinkedList;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week03
 * @Description: leecode104
 * @date Date : 2021年04月12日 23:31
 */
public class TreeMaxDepth {
    /**
     * 采用递归解法
     *
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    private Integer maxDepth = -1;

    /**
     * 采用DFS
     *
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        dfs(root, 0);
        return maxDepth;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            maxDepth = Math.max(maxDepth, level);
            return;
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    /**
     * 采用BFS
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);

                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return depth;
    }


}
