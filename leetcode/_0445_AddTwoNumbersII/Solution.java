package leetcode._0445_AddTwoNumbersII;

import java.util.Stack;

import leetcode.ListNode;

// LinkedList + stack
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> p = new Stack<Integer>();
        Stack<Integer> q = new Stack<Integer>();
        
        while (l1 != null) {
            p.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            q.push(l2.val);
            l2 = l2.next;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        Stack<Integer> tmp = new Stack<Integer>();
        while (!p.empty() || !q.empty()) {
            int x = (!p.empty()) ? p.pop() : 0;
            int y = (!q.empty()) ? q.pop() : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            tmp.push(sum % 10); //再次使用stack反转列表不然结果是反的
        }
        if (carry > 0) {
            tmp.push(1);
        }

        while (!tmp.empty()) {
            curr.next = new ListNode(tmp.pop());
            curr = curr.next;
        }
        return dummyHead.next;
    }
}
