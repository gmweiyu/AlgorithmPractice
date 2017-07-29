package leetcode;

import toolkit.ListNode;

/**
 * Created by Weasley on 2017-03-13.
 */
public class Q24_SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode head=node,tail=head;
        node = new ListNode(2);
        tail.next=node;
        tail=node;
        node = new ListNode(3);
        tail.next=node;
        tail=node;
        node = new ListNode(4);
        tail.next=node;
        tail=node;
        node = new ListNode(5);
        tail.next=node;
        tail=node;

        head = swapPairs(head);
        while (head != null) {
            System.out.print(head.val);
            head=head.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode aux = new ListNode(0);
        aux.next=head;
        head=aux;

        ListNode first,second,temp;

        while (head.next != null) {
            first=head.next;
            second=head.next.next;
            if(second==null){       //奇数个结点，退出
                break;
            }
            temp=second.next;       //提前存储下一次的后继结点
            head.next=second;
            second.next=first;
            first.next=temp;
            head=first;
        }

        return aux.next;
    }
}
