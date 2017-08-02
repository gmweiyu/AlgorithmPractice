package leetcode;

import util.ListNode;

/**
 * Created by Weasley on 2017-04-02.
 */
public class Q82_RemoveDuplicates2 {
    public static void main(String[] args) {
        ListNode head = ListNode.generate(1, 2, 3, 3, 4, 4, 5, 5);
        head=deleteDuplicates(head);
        ListNode.printList(head);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(0),cursor=head,prevNode=head;
        ListNode ans=dummy;
        int times=0;        //记录前一类结点出现的次数
        while (cursor != null) {
            if (cursor.val != prevNode.val) {
                if (times == 1) {       //相邻两个结点不同，且上一个结点只出现一次
                    ans.next = new ListNode(prevNode.val);
                    ans=ans.next;
                }
                times = 1;      //重置出现次数为1
                prevNode=cursor;
            } else {        //相等则次数+1
                times++;
            }
            cursor=cursor.next;
        }
        if(times==1){
            ans.next=new ListNode(prevNode.val);
        }
        return dummy.next;
    }

}
