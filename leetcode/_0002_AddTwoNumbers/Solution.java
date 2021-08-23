package leetcode._0002_AddTwoNumbers;

import leetcode.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // cc

        ListNode dummyNode = new ListNode(0);
        ListNode p1 = l1, p2 = l2, curr = dummyNode;
        int carry = 0;

        while (p1 != null || p2 != null) {
            int x = (p1 != null) ? p1.val : 0;
            int y = (p2 != null) ? p2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }
        if (carry != 0) {
            curr.next = new ListNode(1);
        }
        return dummyNode.next;
    }
}
