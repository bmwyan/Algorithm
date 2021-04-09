package week01;

public class MergeTwoLists {
    /**
     * 递归解法
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;

        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }


    /**
     * 第3种解法:不新建节点方式
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        dummy.next = l1;
        ListNode res = dummy;

        ListNode node1 = null;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                res.next = l1;
                l1 = l1.next;

            } else {
                res.next = l2;
                l2 = l2.next;

            }
            res = res.next;
        }

        res.next = l1 == null ? l2 : l1;

        return dummy.next;
    }

}
