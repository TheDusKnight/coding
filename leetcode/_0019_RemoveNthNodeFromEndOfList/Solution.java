package leetcode._0019_RemoveNthNodeFromEndOfList;
import leetcode.ListNode;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 初始化 fast
        ListNode fast = dummy;
        while (n-- > 0) {
            fast = fast.next;
            if (fast == null) return head;
        }
        
        ListNode slow = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        return dummy.next;
    }
}