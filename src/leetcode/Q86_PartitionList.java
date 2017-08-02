package leetcode;

import util.ListNode;

/**
 * Created by Weasley on 2017-04-04.
 */
public class Q86_PartitionList {
    public static void main(String[] args) {
        ListNode head=new ListNode(2),tail=head;
        tail.next=new ListNode(1);
        tail=tail.next;
        int x=2;
        head=partition(head,x);
        while (head != null) {
            System.out.println(head.val);
            head=head.next;
        }
    }

    public static ListNode partition(ListNode head, int x) {
        //注意：head为dummy
        ListNode firstHead=new ListNode(0),firstTail=firstHead;
        ListNode secondHead=new ListNode(0),secondTail=secondHead;
        while(head!=null){
            int val=head.val;
            if (val < x) {
                firstTail.next=new ListNode(val);
                firstTail=firstTail.next;
            } else{
                secondTail.next=new ListNode(val);
                secondTail=secondTail.next;
            }
            head=head.next;
        }
        firstTail.next=secondHead.next;
        return firstHead.next;
    }

}