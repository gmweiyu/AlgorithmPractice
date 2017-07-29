package leetcode;

import toolkit.ListNode;

/**
 * Created by GuoWeiyu on 2017-06-17.
 */
public class Q92_ReverseLinkedList2 {
    public static void main(String[] args) {
        ListNode head = ListNode.generate(1, 2, 3, 4, 5);
        ListNode newHead = reverseBetween(head, 2, 4);
        ListNode.printList(newHead);
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        int index=1;
        ListNode cur=dummy,prevNode,reverseTail;
        while (index < m) {
            cur=cur.next;
            index++;
        }
        prevNode=cur;       //翻转section的前一个结点
        reverseTail=prevNode.next;  //prevNode后紧随section的head
        cur=reverseTail.next;
        while (index < n) {
            ListNode next=cur.next;
            cur.next=prevNode.next;     //加入新的section head，其next指向原有head
            prevNode.next=cur;      //更新新的head
            reverseTail.next=next;      //链接section的tail至原链表
            cur=next;
            index++;
        }
        return dummy.next;
    }
}
