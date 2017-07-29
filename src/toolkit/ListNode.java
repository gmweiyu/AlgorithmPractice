package toolkit;

/**
 * Created by GuoWeiyu on 2017/07/28.
 * Description: 单链表结点
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    /**
     * 根据传入的数组，按顺序生成单链表
     *
     * @param values 链表结点的值
     * @return 链表的头结点
     */
    public static ListNode generate(int... values) {
        if (values == null || values.length == 0) {
            return null;
        }
        ListNode head = new ListNode(values[0]);
        ListNode prev = head, cur = null;
        for (int i = 1; i < values.length; i++) {
            cur = new ListNode(values[i]);
            prev.next = cur;
            prev = cur;
        }
        return head;
    }

    /**
     * 以当前结点为头结点，顺序打印单链表
     *
     * @param head 顺序打印单链表的头（起始）结点
     */
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
    }
}
