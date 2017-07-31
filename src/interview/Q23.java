package interview;

import toolkit.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GuoWeiyu on 2017/07/31.
 * Description: 如果一个链表中存在环，找出环的入口结点
 */
public class Q23 {
    public static void main(String[] args) {
        ListNode head = ListNode.generate(1, 2, 3, 4, 5);
        ListNode node3 = ListNode.getListNode(head, 3);
        ListNode node5 = ListNode.getListNode(head, 5);
        // 构成环
        node5.next = node3;
        ListNode ans = findTheCircleEntry(head);
        System.out.println(ans);
    }

    private static ListNode findTheCircleEntry(ListNode head) {
        if (head == null) {
            return null;
        }

        // 如果结点已经存在于list中，则说明存在环
        List<ListNode> visit = new ArrayList<>();
        while (head != null) {
            if (visit.contains(head)) {
                return head;
            } else {
                visit.add(head);
            }
            head = head.next;
        }
        return null;
    }
}

