package eightyonetoonehundred;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

/**
 * @author :wqh
 * @description :
 * 86.分隔列表
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 * @create :2020-12-25 10:20:00
 */
public class PartitionList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //制订一个空的头节点
    //队列
    public ListNode partition(ListNode head, int x) {
        Deque<ListNode> biggerQueue = new ArrayDeque<>();
        Deque<ListNode> smallerQueue = new ArrayDeque<>();

        ListNode q = head;
        while (q != null){
            if (q.val >= x){
                biggerQueue.addLast(q);
            }else {
                smallerQueue.addLast(q);
            }
            q = q.next;
        }
        if (smallerQueue.isEmpty()){
            if (biggerQueue.isEmpty()){
                return null;
            }else {
                head = biggerQueue.pollFirst();
            }
        }else {
            head = smallerQueue.pollFirst();
        }
        q = head;
        while (!smallerQueue.isEmpty()){
            q.next = smallerQueue.pollFirst();
            q = q.next;
        }
        while (!biggerQueue.isEmpty()){
            q.next = biggerQueue.pollFirst();
            q = q.next;
        }
        q.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        head = new PartitionList().partition(head,3);
        while (head!= null){
            System.out.println(head.val);
            head = head.next;
        }

    }
}
