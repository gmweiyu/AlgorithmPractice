package interview;

import toolkit.ListNode;

/**
 * Created by GuoWeiyu on 2017/07/28.
 * Description: 在有序单链表中删除重复结点
 */
public class Q18_2 {

    public static void main(String[] args) {
        ListNode head = ListNode.generate(3, 1, 1);
        head = deleteDuplicate(head);
        ListNode.printList(head);
    }

    private static ListNode deleteDuplicate(ListNode head) {
        if (head == null) {
            return null;
        }

        // 辅助头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode cur = dummy, dup = cur.next;

        int time = 1;

        while (dup != null) {
            ListNode next = dup.next;
            if (next == null || next.val != dup.val) {
                if (time == 1) {
                    cur = dup;
                    dup = next;
                } else {
                    cur.next = next;
                    dup = cur.next;
                    time = 1;
                }
            } else {
                dup = next;
                time++;
            }
        }

        return dummy.next;
    }
}
