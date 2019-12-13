package Sixty_OneToEighty;

/**
 * @author wub
 * LeetCode
 * 61.Rotate List
 * 每次把链表最后一个结点放到第一个，重复k次
 */
//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
public class RotateList {


    //思路：k=k%总结点数，然后把最后k个结点放到链表起始位置
    //p先遍历k个结点，然后q从头结点开始一起遍历，当p到达末尾时，q到达p的前k个结点
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        ListNode p = head;
        for (int i = 1; i <= k; i++) {
            if (p.next == null){
                //i为结点总数
                k = k%i;
                if (k == 0) return head;
                p = head;
                i = 0;
                continue;
            }
            p = p.next;
        }
        ListNode q = head;
        while (p.next != null){
            p = p.next;q = q.next;
        }
        p.next = head;
        head = q.next;
        q.next = null;
        return head;
    }

    public static void main(String[] args) {
        RotateList atn = new RotateList();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
//        l1.next.next.next = new ListNode(4);
//        l1.next.next.next.next = new ListNode(5);
        ListNode l3 = atn.rotateRight(l1,4);
        while (l3 != null) {
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }
}
