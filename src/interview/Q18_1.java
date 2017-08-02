package interview;

import util.ListNode;

/**
 * Created by GuoWeiyu on 2017/07/28.
 * Description: 删除单链表的指定结点
 */
public class Q18_1 {
    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};
        ListNode head = ListNode.generate(values);
        ListNode.printList(head);
    }

    private static void delete(ListNode head, ListNode node) {
        if (head == null || node == null) {
            return;
        }
        if (head == node || node.next == null) {
            node = null;
            return;
        }
        node.val=node.next.val;
        node.next= node.next.next;
    }

}
