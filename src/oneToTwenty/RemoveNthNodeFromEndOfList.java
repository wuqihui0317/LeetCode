package oneToTwenty;
/**
 * @author wub
 * LeetCode
 * 19.Remove Nth Node From End of List
 * 删除head节点中倒数第n个节点
 */

import java.util.ArrayList;
/**
 * Definition for singly-linked list. 在AddTwoNumbers中定义过
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class RemoveNthNodeFromEndOfList {
    //My stupid method by ArrayList
    public ListNode removeNthFromEnd_Stupid(ListNode head, int n) {
        ArrayList<ListNode> list = new ArrayList<>();
        if (head.next == null)
            return null;
        list.add(head);
        while (head.next != null) {
            list.add(head.next);
            head = head.next;
        }
        if (n == list.size())
            return list.get(1);
        int index = list.size() - n;
        list.get(index - 1).next = list.get(index).next;
        return list.get(0);
    }

    //A wonderful method
    //从头结点开始数到第n个node(第n+1个节点)，如果是null，说明一共就n个节点，直接返回头结点的next
    //      如果不是null，从这个节点数到尾节点，同时另一个从头结点开始数
    //      等数到尾节点时，另一个节点就数到了倒数第n+1个节点
    //code:
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode find = head;
        for (int i = 0; i < n; i++)
            head = head.next;
        if (head == null || head.next == null)
            return find.next;
        ListNode result = find;
        while (head.next != null) {
            head = head.next;
            find = find.next;
        }
        if (n == 1) find.next = null;
        else find.next = find.next.next;
        return result;
    }
}
