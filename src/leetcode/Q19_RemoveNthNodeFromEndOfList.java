package leetcode;

import toolkit.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Weasley on 2017-03-09.
 */
public class Q19_RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        ListNode head,tail;
        head=tail= new ListNode(1);
        tail.next = new ListNode(2);
        tail=tail.next;
        tail.next = new ListNode(3);
        tail=tail.next;
        tail.next = new ListNode(4);
        tail=tail.next;
        tail.next = new ListNode(5);
        tail=tail.next;

        head = removeNthFromEnd_3(head, 3);
        while (head != null) {
            System.out.println(head.val);
            head=head.next;
        }

    }

    /**
     * 基础解法：两次pass，需要计算链表的长度length
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int length=0;
        ListNode firstHeadNode=head;
        while (firstHeadNode!=null) {
            length++;
            firstHeadNode=firstHeadNode.next;
        }
        ListNode secondHeadNode=head;
        for(int i=0;i<length;i++) {
            if (i == length - n-1) {
                secondHeadNode.next=secondHeadNode.next.next;
                break;
            }
            secondHeadNode=secondHeadNode.next;
        }
        return head;
    }


    /**
     * 一次遍历，需要另外记录存储每个结点
     */
    public static ListNode removeNthFromEnd_2(ListNode head, int n) {
        List<ListNode> lists=new ArrayList<ListNode>();
        ListNode node;
        while (head != null) {
            node=head;
            lists.add(node);
            head=head.next;
        }

        int length=lists.size();        //链表长度
        if(length==1)
            return null;
        if(length==n)
            lists.remove(0);
        else
            lists.get(length - n - 1).next = lists.get(length - n -1).next.next;
        return lists.get(0);
    }

    /**
     * 一次遍历，需要设置一个辅助头结点aux，用来处理特殊情况（删除第一个）
     * 设置两个指针first、second，first先走n+1步，保持间隔，first、second一起移动
     * 直到first到末尾
     */
    public static ListNode removeNthFromEnd_3(ListNode head, int n) {
        ListNode aux = new ListNode(0);
        aux.next=head;
        ListNode first=aux,second=aux;
        for(int i=1;i<=n+1;i++)
            first=first.next;

        while (first != null) {
            first=first.next;
            second=second.next;
        }
        second.next=second.next.next;
        return aux.next;
    }
}
