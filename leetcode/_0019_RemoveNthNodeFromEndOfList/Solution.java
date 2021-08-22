package leetcode._0019_RemoveNthNodeFromEndOfList;
import leetcode.ListNode;

// slow fast pointer two pass
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        
        ListNode dummy = new ListNode(0); // 防止只有一个node情况
        dummy.next = head;
        // 初始化 fast
        ListNode fast = dummy;
        while (n-- > 0) {
            fast = fast.next;
            if (fast == null) return head; // 防止没有需要remove的nth node的情况
        }
        
        ListNode slow = dummy;
        while (fast != null && fast.next != null) { // fast.next 防止slow null pointer
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        return dummy.next;
    }
}