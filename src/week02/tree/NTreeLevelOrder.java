package week02.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week02.tree
 * @Description: TODO
 * @date Date : 2021年04月10日 23:10
 */
public class NTreeLevelOrder {

    /**
     * 采用广度优先搜索的方式
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(root);
        int count = 1;

        while (!queue.isEmpty()) {
            List<Integer> l = new ArrayList<>();
            int start = 0;
            int nextCount = 0;
            while (start++ < count) {
                Node node = queue.pop();
                if (node != null) {
                    l.add(node.val);
                    if (node.children != null && !node.children.isEmpty()) {
                        for (Node child : node.children) {
                            queue.add(child);
                            nextCount++;
                        }
                    }
                }

            }
            count = nextCount;
            res.add(l);
        }

        return res;
    }
}
