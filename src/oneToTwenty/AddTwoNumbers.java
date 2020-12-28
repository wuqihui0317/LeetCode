package oneToTwenty;
/**
 * @author wub
 * LeetCode
 * 2.Add Two Numbers
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = new ListNode(0);
        ListNode p = result;
        while (l1 != null && l2 != null) {
            int n = l1.val + l2.val + carry;
            carry = n / 10;
            p.next = new ListNode(n % 10);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int n = l1.val + carry;
            carry = n / 10;
            p.next = new ListNode(n % 10);
            p = p.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int n = l2.val + carry;
            carry = n / 10;
            p.next = new ListNode(n % 10);
            p = p.next;
            l2 = l2.next;
        }
        if (carry != 0)
            p.next = new ListNode(carry);
        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        AddTwoNumbers atn = new AddTwoNumbers();
        ListNode l3 = atn.addTwoNumbers(l1, l2);
        while (l3 != null) {
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }
}
