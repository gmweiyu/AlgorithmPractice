package interview;

import toolkit.ListNode;

/**
 * Created by GuoWeiyu on 2017/07/31.
 * Description: 找到单链表倒数第n个结点（需考虑n超出链表的长度）
 */
public class Q22 {
    public static void main(String[] args) {
        ListNode head = ListNode.generate(1, 2, 3, 4, 5, 6);
        int n = 8;
        ListNode res = findTheReverseN(head, n);
        System.out.println(res);
    }

    private static ListNode findTheReverseN(ListNode head, int n) {
        if (head == null || n < 1) {
            return null;
        }

        // 记录链表的长度
        int length = -1;
        ListNode first = head, second = head;
        // 记录first结点先移动的距离
        int index = 1;
        while (index < n && first != null) {
            index++;
            first = first.next;
        }
        // 如果index仍然<n，则说明n超出了链表的长度
        // 如果index==n，并且first==null，说明刚好超出长度1
        // 则需要对n求模
        if (index < n || (first == null && index == n)) {
            length = index - 1;
            n %= length;
            first = head;
            index = 1;
            while (index < n) {
                index++;
                first = first.next;
            }
        }
        // 找出倒数第n个结点
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }
}
