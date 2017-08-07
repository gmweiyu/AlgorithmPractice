package interview;

import util.ListNode;

/**
 * Created by GuoWeiyu on 2017/08/06.
 * Description: 查找两个链表中的第一个相同结点
 * 方法1：Brute-Force
 * 方法2：使用两个辅助栈，从栈顶（即链尾）开始比较
 * 方法3：找到两个链表的长度之差，使用Two-Pointer找到相同的结点{@link #findFirstCommon(ListNode, ListNode)}
 */
public class Q52 {
    public static void main(String[] args) {

    }

    /**
     * 采用方法3实现
     */
    private static ListNode findFirstCommon(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        int length1 = ListNode.length(head1);
        int length2 = ListNode.length(head2);
        int lengthOffset = Math.abs(length1 - length2);
        if (length1 > length2) {
            for (int i = 0; i < lengthOffset; i++) {
                head1 = head1.next;
            }
        } else if (length1 < length2) {
            for (int i = 0; i < lengthOffset; i++) {
                head2 = head2.next;
            }
        }

        while (head1 != null && head2 != null && head1 != head2) {
            head1 = head1.next;
            head2 = head2.next;
        }

        return head1;
    }
}
