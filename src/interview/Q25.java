package interview;

import util.ListNode;

/**
 * Created by GuoWeiyu on 2017/07/31.
 * Description: 合并两个已排序的链表，新链表仍然有序
 */
public class Q25 {
    public static void main(String[] args) {
        ListNode head1 = ListNode.generate(1, 2, 5, 7);
        ListNode head2 = ListNode.generate(2, 4, 6, 8);
        ListNode ans = merge(head1, head2);
        ListNode.printList(ans);
    }

    private static ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;
        // 两个链表均未到达tail，按照value大小顺序链接
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                ans.next = node1;
                node1 = node1.next;
            } else {
                ans.next = node2;
                node2 = node2.next;
            }
            ans = ans.next;
        }
        // 如果任意一个链表到达了tail，则直接连接另一个链表
        if (node1 == null) {
            ans.next = node2;
        }
        if (node2 == null) {
            ans.next = node1;
        }
        return dummy.next;
    }
}
