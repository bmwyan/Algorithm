package week01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {



    /**
     * 采用优先级队列方式
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if(lists==null||lists.length==0)
        {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1,o2)->(o1.val-o2.val));

        ListNode dummy = new ListNode(-1);
        ListNode p=dummy;

        for(ListNode node:lists)
        {
            if(node!=null)
            {
                queue.add(node);
            }

        }

        while(!queue.isEmpty())
        {
            p.next = queue.poll();
            p=p.next;
            if(p.next!=null)
            {
                queue.add(p.next);
            }
        }
        return dummy.next;
    }


    private void compare()
    {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1, ListNode o2) {

                if(o1.val<o2.val)
                {
                    return -1;
                }else if(o1.val==o2.val)
                {
                    return 0;
                }else{
                    return 1;
                }
            }
        });
    }


    /**
     * 采用递归方式
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0)
        {
          return null;
        }
        if(lists.length==1)
        {
            return lists[0];
        }
        if(lists.length==2)
        {
            return mergeTwoLists(lists[0],lists[1]);
        }

        ListNode[] rest = Arrays.copyOfRange(lists,1,lists.length);
        ListNode res = this.mergeTwoLists(lists[0],this.mergeKLists(rest));
        return res;


    }

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
}
