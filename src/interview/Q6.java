package interview;

import toolkit.ListNode;

import java.util.Stack;

/**
 * Created by GuoWeiyu on 2017/07/24.
 * Description: 从尾到头打印链表
 */
public class Q6 {
    public static void main(String[] args) {
        ListNode head = ListNode.generate(1, 2, 3, 4, 5);

        printStack(head);
    }

    /**
     * 递归实现逆序打印
     * 优点：简洁
     * 缺点：链表过长时，函数调用栈溢出
     * @param head
     */
    private static void printRecursive(ListNode head){
        if (head == null) {
            return;
        }
        printRecursive(head.next);
        System.out.println(head.val);
    }

    private static void printStack(ListNode head) {
        if (head == null) {
            return;
        }
        Stack<ListNode> stack=new Stack<>();
        // 链表结点入栈
        while (head != null) {
            stack.push(head);
            head=head.next;
        }
        // 出栈，即逆序
        while (!stack.isEmpty()) {
            System.out.println(stack.pop().val);
        }
    }

}
