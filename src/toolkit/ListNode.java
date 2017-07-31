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

    /**
     * 从给定的链表中找到指定value的结点
     * 如果给定value在链表中存在重复结点，则返回第一个出现的
     * @param value 指定value
     * @return 目标value的结点
     */
    public static ListNode getListNode(ListNode head, int value) {
        if (head == null) {
            return null;
        }
        while (head != null) {
            if (head.val == value) {
                return head;
            }
            head=head.next;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Value: "+val;
    }
}
