package week03;

import meta.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TreeHasPathSumTest {
    TreeHasPathSum t = new TreeHasPathSum();
    TreeNode root;
    TreeNode root2;

    //  3
    //
    @Before
    public void setUp() throws Exception {
        TreeNode rL = new TreeNode(9);
        TreeNode n31 = new TreeNode(15);
        TreeNode n32 = new TreeNode(7);
        TreeNode rR = new TreeNode(20, n31, n32);
        root = new TreeNode(3, rL, rR);

        TreeNode s = new TreeNode(2);
        root2 = new TreeNode(1, s, null);

    }

    @Test
    public void hasPathSum() {
        boolean flag = t.hasPathSum(root, 30);
        assertEquals(true, flag);
    }

    @Test
    public void hasPathSum2() {
        boolean flag = t.hasPathSum(root2, 1);
        assertEquals(true, flag);
    }
}