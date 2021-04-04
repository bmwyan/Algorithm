package week01;

public class MergeTwoLists {
    /**
     * 递归解法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if(l1.val<l2.val)
        {
            l1.next=mergeTwoLists2(l1.next,l2);
            return l1;
        }else
        {
            l2.next = mergeTwoLists2(l2.next,l1);
            return l2;
        }
    }


    /**
     * 第1种解法:采用新建节点方式
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

        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        while (l1 != null && l2 != null) {
            ListNode newNode = l1.val <l2.val?  new ListNode(l1.val): new ListNode(l2.val);
            res.next = newNode;
            res = newNode;
            if (l1.val < l2.val) {
                l1 = l1.next;
            } else {
                l2 = l2.next;
            }
        }
        res.next=l1!=null?l1:l2;

        return dummy.next;
    }


    /**
     * 第3种解法:不新建节点方式
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                res.next=l1;
                l1 = l1.next;
            } else {
                res.next=l2;
                l2 = l2.next;
            }
            res=res.next;
        }
        res.next=l1!=null?l1:l2;

        return dummy.next;
    }

}
