package Twenty_OneToFourty;
/**
 * @author wub
 * LeetCode
 * 23.Merge k Sorted Lists
 * 将k个升序ListNode合并成一条 并保持升序
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class MergeKSortedLists {
    //两两合并
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        int i = 0;
        int j = lists.length-1;
        while(j>0){
            while (i<j){
                lists[i] = mergeTwoLists(lists[i],lists[j]);
                i++;j--;
            }
            i = 0;
        }
        return lists[0];
    }
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
