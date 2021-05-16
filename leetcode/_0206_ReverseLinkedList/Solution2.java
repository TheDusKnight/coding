package leetcode._0206_ReverseLinkedList;
import leetcode.ListNode;

// recursion
public class Solution2 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = reverseList(head.next);
        // wall
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
