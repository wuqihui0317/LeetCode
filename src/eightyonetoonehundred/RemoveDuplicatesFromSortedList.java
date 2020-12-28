package eightyonetoonehundred;

/**
 * @author :wqh
 * @description :
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * @create :2020-12-17 10:31:00
 */
public class RemoveDuplicatesFromSortedList {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode p = head.next;
        ListNode q = head;
        int nowVal = head.val;
        head.next = null;
        while (p != null){
            if (p.val != nowVal){
                q.next = p;
                q = p;
                nowVal =p.val;
            }
            p = p.next;
            q.next = null;
        }
        return head;
    }
}
