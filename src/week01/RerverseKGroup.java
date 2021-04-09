package week01;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week01
 * @Description: TODO
 * @date Date : 2021年04月05日 17:00
 */
public class RerverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }

            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = this.reverseList(start);

            start.next = next;
            pre = start;
            end = pre;
        }

        return dummy.next;
    }

    /**
     * 采用迭代的方法
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;

    }
}
