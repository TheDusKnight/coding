package leetcode._0025_ReverseNodesInKGroup;
import leetcode.ListNode;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        // 检验该区间是否符合k-group
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            if (cur == null) return head;
            cur = cur.next;
        }

        // 如果符合，那么前进k个node;
        ListNode countHead = head;
        for (int i = 0; i < k; i++) {
            countHead = countHead.next;
        }
        ListNode preHead = reverseKGroup(countHead, k);
        // wall
        // reverse linked list by one iteration
        ListNode prev = preHead;
        ListNode curr = head;
        ListNode temp = null;

        for (int i = 0; i < k; i++) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
