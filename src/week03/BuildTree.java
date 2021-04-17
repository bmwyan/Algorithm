package week03;

import meta.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week03
 * @Description: leecode105 从前序与中序遍历序列中构造二叉树
 * @date Date : 2021年04月18日 0:19
 */
public class BuildTree {

    //节点取值 ，数组下标
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int i = 0;
        for (int t : inorder) {
            map.put(inorder[i], i);
            i++;
        }
        int n = inorder.length;
        TreeNode root = buildTree(preorder, inorder, 0, n - 1, 0, n - 1);
        return root;
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preOrderLeft, int preOrderRight, int inOrderLeft, int inOrderRight) {
        if (preOrderLeft > preOrderRight) {
            return null;
        }
        //根节点
        TreeNode root = new TreeNode(preorder[preOrderLeft]);
        int preOrderRoot = preOrderLeft;
        //中序遍历中找到根节点所在位置
        int inOrderRoot = map.get(preorder[preOrderLeft]);
        //左子树大小
        int leftTreeSize = inOrderRoot - inOrderLeft;
        //左子树中序遍历范围 [inOrderLeft,inOrderRoot-1]
        //左子树中前序遍历范围[preOrderLeft+1,preOrderLeft+1+leftTreeSize];
        TreeNode leftTree = this.buildTree(preorder, inorder, preOrderLeft + 1, preOrderLeft + leftTreeSize, inOrderLeft, inOrderRoot - 1);

        //右子树中序遍历范围 [inOrderRoot+1,inOrderRight]
        //右子树中前序遍历范围[];
        TreeNode rightTree = this.buildTree(preorder, inorder, preOrderLeft + 1 + leftTreeSize, preOrderRight, inOrderRoot + 1, inOrderRight);
        root.left = leftTree;
        root.right = rightTree;
        return root;
    }
}
