package leetcode;

import toolkit.ListNode;

/**
 * Created by Weasley on 2017-04-02.
 */
public class Q83_RemoveDuplicates {
    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)  return head;
        ListNode cur=head.next,prev=head;        //两个分别
        while (cur != null) {
            if (cur.val == prev.val) {
                prev.next = cur.next;       //删除cur
            } else {
                prev=cur;       //向后移动
            }
            cur=cur.next;
        }
        return head;
    }
}
