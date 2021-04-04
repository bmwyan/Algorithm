package week01;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)
        {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next= head;
        ListNode p= dummy;
        while(p.next!=null&&p.next.next!=null)
        {
            ListNode node1=p.next;
            ListNode node2=p.next.next;
            node1.next=node2.next;
            node2.next=node1;
            p.next=node2;
            p=node1;

        }
        return dummy.next;
    }
}
