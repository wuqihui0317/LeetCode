package twenty_OneToFourty;
/**
 * @author wub
 * LeetCode
 * 24.Swap Nodes in Pairs
 * 每两个一组 交换两个结点
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class SwapNodesInPairs {
    /*
    //递归
    public ListNode swapPairs(ListNode head) {
        //没有结点或者只有一个结点
        if (head == null || head.next == null)
            return head;
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
    */

    //非递归
    public ListNode swapPairs(ListNode head){
        ListNode result = head;
        if (head == null || head.next == null){
            return result;
        }
        result = head.next;
        ListNode next = result.next;//下一组的第一个结点
        result.next = head;
        ListNode pre = head;//下一对的前驱结点
        //如果还有下一组，则一直循环
        while(next != null && next.next != null){
            ListNode temp = next.next.next;//暂时记录下一组的第一个结点
            pre.next = next.next;//前驱结点的下一个结点是这组的第二个结点
            next.next.next = next;//该组的第二个结点的下一个结点设为第一个结点
            pre = next;//pre更新为这组的第一个结点
            next = temp;//next更新为下一对的第一个结点
        }
        pre.next = next;
        return result;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        one.next = two;
        two.next = three;
        three.next = four;
        ListNode r = new SwapNodesInPairs().swapPairs(one);
        for (int i = 0; i < 4; i++) {
            System.out.println(r.val);
            r = r.next;
        }
    }
}
