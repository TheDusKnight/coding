package leetcode._0024_SwapNodesInPairs;
import leetcode.ListNode;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode preHead = swapPairs(head.next.next);
        head.next.next = head;
        ListNode newHead = head.next;
        head.next = preHead;
        return newHead;
    }
}
