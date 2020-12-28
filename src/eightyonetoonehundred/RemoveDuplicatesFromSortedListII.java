package eightyonetoonehundred;

/**
 * @author :wqh
 * @description :
 * @create :2020-12-16 10:11:00
 */
public class RemoveDuplicatesFromSortedListII {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.val == head.val) {
            //跳过所有同值节点
            head = head.next;
            while (head.next != null && head.next.val == head.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }

}
