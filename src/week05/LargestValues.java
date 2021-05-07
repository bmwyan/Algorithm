package week05;

import meta.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week05
 * @Description: Leecode515 在每一树行中找最大值
 * @date Date : 2021年05月01日 18:45
 */
public class LargestValues {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max=Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                max=Math.max(max,node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }

                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            res.add(max);
        }
        return res;
    }

}
