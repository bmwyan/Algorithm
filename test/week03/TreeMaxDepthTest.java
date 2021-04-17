package week03;

import meta.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TreeMaxDepthTest {
    TreeMaxDepth tree = new TreeMaxDepth();
    TreeNode root;


    @Before
    public void setUp() throws Exception {
        TreeNode rL = new TreeNode(9);
        TreeNode n31 = new TreeNode(15);
        TreeNode n32 = new TreeNode(7);
        TreeNode rR = new TreeNode(20, n31, n32);
        root = new TreeNode(3, rL, rR);
    }

    @Test
    public void maxDepth() {
        assertEquals(3, tree.maxDepth(root));
    }
}