package leetcode;

import toolkit.ListNode;

/**
 * Created by Weasley on 2017-03-26.
 */
public class Q61_RotateList {
    public static void main(String[] args) {
        ListNode head = ListNode.generate(1, 2, 3, 4, 5);

        head = rotateRight(head, 9999999);

        ListNode.printList(head);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null||k==0)    return head;
        ListNode left=head,right=head;
        int count=0,flag=0;
        for(int i=0;i<k;i++){
            if (right == null) {
                right = head;
                flag=1;     //找到了链表的尾部
                break;
            }
            count++;        //链表结点总数
            right=right.next;
        }

        if(flag==1){        //如果找到了尾部，则可以过滤掉重复的遍历
            if(k%count==0)  return head;
            for(int i=0;i<k%count;i++)  right=right.next;
        }else{
            if(right==null) return head;        //如果到了尾部，但flag没能记录(n=1,k=1)
        }
        while (right.next!= null) {
            left=left.next;
            right=right.next;
        }
        ListNode newHead=left.next;
        left.next=null;     //尾节点
        right.next=head;
        return newHead;
    }

    //可以先遍历出长度，再首尾连接环，最后处理移动及解开环

}
