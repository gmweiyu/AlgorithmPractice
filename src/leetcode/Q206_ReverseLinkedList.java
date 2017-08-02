package leetcode;

import util.ListNode;

/**
 * Created by Weasley on 2017-04-06.
 */
public class Q206_ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head=new ListNode(1),tail=head;
        tail.next=new ListNode(2);
        tail=tail.next;
        tail.next=new ListNode(3);
        tail=tail.next;
        tail.next=new ListNode(4);
        tail=tail.next;
        tail.next=new ListNode(5);
        tail=tail.next;
        head=reverseList_2(head);
        while (head != null) {
            System.out.println(head.val);
            head=head.next;
        }
    }

    //方法1：迭代求解
    public static ListNode reverseList(ListNode head) {
        if(head==null)  return null;
        ListNode prev=null;     //当前结点的前一结点
        ListNode next=null;     //以前指向下一结点
        while(head!=null){     //提前退出
            next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
    }

    //方法2：递归求解
    public static ListNode reverseList_2(ListNode list) {
        if (list == null) return null; // first question

        if (list.next == null) return list; // second question

        // third question - in Lisp this is easy, but we don't have cons
        // so we grab the second element (which will be the last after we reverse it)

        ListNode secondElem = list.next;

        // bug fix - need to unlink list from the rest or you will get a cycle
        list.next = null;

        // then we reverse everything from the second element on
        ListNode reverseRest = reverseList_2(secondElem);

        // then we join the two lists
        secondElem.next = list;

        return reverseRest;
    }

}
