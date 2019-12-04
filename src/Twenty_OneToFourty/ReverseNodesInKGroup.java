package Twenty_OneToFourty;
/**
 * @author wub
 * LeetCode
 * 25.Reverse Nodes in k-Group
 * 每k个一组 逆置结点；不足k个的结点组不需要改变
 */

/**
 * 递归性质
 *比如对一个链表以两个结点为一组反转链表，那么后面的这些节点也是一条链表，而且规模比原来这条链表小
 * 这就叫子问题
 * 这样就可以通过递归一步步缩小问题
 */
public class ReverseNodesInKGroup {
    //用一个大小为k的数组存下k个结点，逆序排列
    /*
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode[] group = new ListNode[k];
        ListNode result = head;
        ListNode pre = null;//前一组的最后一个结点
        for (int i = 0; true; i++) {
            for (int j = 0; j < k; j++) {
                if (head != null) {
                    group[j] = head;
                    head = head.next;
                }
                else{
                    if (pre != null)    pre.next = group[0];
                    return result;
                }
            }
            if (pre != null)    pre.next = group[k-1];
            head = group[k-1].next;
            pre = group[0];
            for (int j = k-1; j > 0; j--)
                group[j].next = group[j-1];
            if (i == 0)
                result = group[k-1];
            group[0] = null;
        }
    }
     */

    //递归方法
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || head == null)
            return head;
        ListNode end = head;
        for (int i = 0; i < k-1; i++) {
            if (end != null)
                end = end.next;
            else    return head;
        }
        ListNode next = end.next;
        ListNode result = reverse(head,end);
        head.next = reverseKGroup(next,k);
        return result;
    }

    /**
     * 反转a~b的链表
     * @param a 头结点
     * @param b 尾节点
     * @return 反转后的链表
     */
    public ListNode reverse(ListNode a,ListNode b){
        ListNode now = a;
        ListNode pre = null;
        ListNode next = now.next;
        while(now != b){
            now.next = pre;
            pre = now;
            now = next;
            next = next.next;
        }
        b.next = pre;
        return b;
    }
}
