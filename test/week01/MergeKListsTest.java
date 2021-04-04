package week01;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeKListsTest {
    MergeKLists m = new MergeKLists();
    @Test
    public void mergeKLists() {

        ListNode nd1 = new ListNode(1);
        ListNode nd2 = new ListNode(2);
        ListNode nd3 = new ListNode(3);
        m.mergeKLists(new ListNode[]{nd1,nd2,nd3});
    }
}