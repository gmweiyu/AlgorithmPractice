package interview;

import util.ListNode;

/**
 * Created by GuoWeiyu on 2017/07/31.
 * Description:
 */
public class Q24 {
    public static void main(String[] args) {
        ListNode head = ListNode.generate(1,2);
        ListNode ans=reverse(head);
        ListNode.printList(ans);
    }

    private static ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode prev=null;
        ListNode cur=head;
        ListNode next;
        // 翻转操作
        while (cur.next != null) {
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        // 连接最后一个结点
        cur.next=prev;
        return cur;
    }
}
