package leetcode._0002_AddTwoNumbers;

import leetcode.ListNode;

class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode dummy = new ListNode(), cur = dummy;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int curVal = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            cur.next = new ListNode(curVal);
            
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }
        
        while (l1 != null) {
            int curVal = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            cur.next = new ListNode(curVal);
            
            l1 = l1.next;
            cur = cur.next;
        }
        
        while (l2 != null) {
            int curVal = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;
            cur.next = new ListNode(curVal);
            
            l2 = l2.next;
            cur = cur.next;
        }
        
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        
        return dummy.next;
    }
}
