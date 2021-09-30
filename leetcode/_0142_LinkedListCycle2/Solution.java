package leetcode._0142_LinkedListCycle2;
import leetcode.ListNode;

// slow fast pointer 数学解和287. Find the Duplicate Number类似
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) break;
        }
        
        if (slow != fast) return null; // check 是不是break出来的
        
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
}