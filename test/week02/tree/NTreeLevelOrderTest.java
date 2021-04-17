package week02.tree;

import meta.Node;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class NTreeLevelOrderTest {
    NTreeLevelOrder level = new NTreeLevelOrder();

    Node root = null;

    @Before
    public void setUp() throws Exception {
        Node node11=new Node(5);
        Node node12=new Node(6);
        List<Node> n1children = new ArrayList<Node>() ;
        n1children.add(node11);
        n1children.add(node12);
        Node node1 = new Node(3,n1children);

        Node node2 = new Node(2);
        Node node3 = new Node(4);
        List<Node> children = new ArrayList<Node>() ;
        children.add(node1);
        children.add(node2);
        children.add(node3);
        root = new Node(1,children);
    }

    @Test
    public void levelOrder() {
        level.levelOrder(root);
    }
}