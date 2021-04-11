package week02.tree;

import java.util.*;

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
     * 采用BFS
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> li = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                li.add(node.val);
                queue.addAll(node.children);
            }
            res.add(li);

        }
        return res;
    }

    /**
     * 采用DFS
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Map<Integer, List<Integer>> levelMap = new HashMap<>();
        dfs(root, 0, levelMap);

        res = new ArrayList<List<Integer>>(levelMap.values());
        return res;
    }

    /**
     * @param root
     * @param level
     * @param levelMap
     */
    private void dfs(Node root, int level, Map<Integer, List<Integer>> levelMap) {
        if (root == null) {
            return;
        }
        if (levelMap.get(level) == null) {
            levelMap.put(level, levelMap.getOrDefault(level, new ArrayList<Integer>()));
        }
        levelMap.get(level).add(root.val);
        for (Node child : root.children) {
            this.dfs(child, level + 1, levelMap);
        }
    }
}
