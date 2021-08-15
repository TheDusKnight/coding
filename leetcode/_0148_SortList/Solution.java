package leetcode._0148_SortList;
import leetcode.ListNode;

// CURD + Divide and Conquer
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head, fast = head, prev = null;

        // Find the mid of the list
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // while loop结束后slow正好是mid
        // 一劈两半
        prev.next = null;

        // Divide and Conquer
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return mergeList(l1, l2); // 返回左半部分和右半部分merge好后的头节点
    }

    // lc 21
    private ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        cur.next = l1 != null ? l1:l2;

        ListNode result = dummy.next;
        dummy.next = null; // 也可以直接return dummy.next
        return result; // return merge后的头节点
    }
}
