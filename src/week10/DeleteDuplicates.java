package week10;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week10
 * @Description: leecode83 删除排序链表中的重复元素
 * @date Date : 2021年06月08日 22:26
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode dummy = new ListNode(-101);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (pre != null && cur != null) {
            if (cur.val == pre.val) {
                ListNode node = cur.next;
                pre.next = node;
                cur = node;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }

        return dummy.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        while (cur.next != null){
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

}
