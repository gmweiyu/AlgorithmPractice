package leetcode;

import util.ListNode;

/**
 * Created by Weasley on 2017-03-10.
 */
public class Q21_MergeTwoSortedLists {
    public static void main(String[] args) {

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)    return l2;
        if(l2==null)    return l1;

        ListNode aux = new ListNode(0);
        ListNode head=aux;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                head.next = l2;
                l2 = l2.next;
            } else {
                head.next=l1;
                l1=l1.next;
            }
            head=head.next;
        }
        if(l1==null)    head.next=l2;
        if(l2==null)    head.next=l1;
        return aux.next;
    }

}
