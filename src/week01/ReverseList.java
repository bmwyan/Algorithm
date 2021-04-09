package week01;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week01
 * @Description: TODO
 * @date Date : 2021年04月05日 16:34
 */
public class ReverseList {

    /**
     * 采用迭代的方法
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null) {
            cur.next=pre;
            pre=cur;
            cur=cur.next;
        }
        return pre;
    }

    /**
     * 采用递归的方法
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
