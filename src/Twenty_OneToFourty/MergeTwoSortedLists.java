package Twenty_OneToFourty;

import java.util.List;

/**
 * @author wub
 * LeetCode
 * 21.Merge Two Sorted Lists
 * 将两个ListNode合并成一个
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode result = l2;
        if (l1.val < l2.val) {
            result = l1;
            l1 = l1.next;
        }
        else    l2 = l2.next;
        ListNode rear = result;
        while(l1 != null && l2 != null){
            if (l1.val < l2.val){
                rear.next = l1;
                rear = l1;
                l1 = l1.next;
            }
            else{
                rear.next = l2;
                rear = l2;
                l2 = l2.next;
            }
        }
        if(l1 == null)
            rear.next = l2;
        else if (l2 == null)
            rear.next = l1;
        return result;
    }
}
