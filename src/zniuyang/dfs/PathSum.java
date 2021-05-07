package zniuyang.dfs;

import meta.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package zniuyang.dfs
 * @Description: leecode113 路径总和II
 * @date Date : 2021年05月03日 18:42
 */
public class PathSum {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }

        LinkedList<Integer> list = new LinkedList<>();
        dfs(root, targetSum, list);
        return res;
    }

    private void dfs(TreeNode root, int targetSum, LinkedList<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left == null && root.right == null && targetSum == root.val) {
            res.add(new ArrayList<>(list));
            list.removeLast();
            return;
        }


        dfs(root.left, targetSum - root.val, list);
        dfs(root.right, targetSum - root.val, list);
        list.removeLast();
    }

}
