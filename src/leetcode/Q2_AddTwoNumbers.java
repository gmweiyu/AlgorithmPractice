package leetcode;

import util.ListNode;

/**
 * Created by Weasley on 2017-02-22.
 * AC
 */
public class Q2_AddTwoNumbers {
    public static void main(String[] args) {
        //链表1
        ListNode head1 = ListNode.generate(9, 9, 9);
        //链表2
        ListNode head2 = ListNode.generate(9, 5, 4);

        ListNode res = addTwoNumbers_2(head1, head2);

        ListNode.printList(res);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head=null,tail=null;
        //进位初始为0
        int carry=0;
        while (l1 != null && l2 != null) {
            int value=l1.val+l2.val+carry;
            carry=value/10;     //更新进位
            value%=10;
            l1=l1.next;
            l2=l2.next;
            if (head == null) {
                head=new ListNode(value);
                tail=head;  //首尾相同
                continue;
            }
            ListNode node=new ListNode(value);
            tail.next=node;
            tail=node;
        }
        while (l1 != null) {
            int value=l1.val+carry;
            carry=value/10;
            value%=10;
            ListNode t=new ListNode(value);
            tail.next=t;
            tail=t;
            l1=l1.next;
        }
        while (l2 != null) {
            int value=l2.val+carry;
            carry=value/10;
            value%=10;
            ListNode t=new ListNode(value);
            tail.next=t;
            tail=t;
            l2=l2.next;
        }
        if (carry != 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    /**
     * 简洁版本
     */
    public static ListNode addTwoNumbers_2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p=l1,q=l2,tail=head;
        int carry=0;        //进位
        while (p != null || q != null) {
            int x=(p==null)?0:p.val;        //如果为空则按0处理
            int y=(q==null)?0:q.val;
            int value=x+y+carry;
            carry=value/10;
            tail.next = new ListNode(value % 10);
            tail=tail.next;
            if(p!=null)
                p=p.next;
            if(q!=null)
                q=q.next;
        }
        if (carry != 0) {
            tail.next = new ListNode(carry);
        }

        return head.next;
    }

}

