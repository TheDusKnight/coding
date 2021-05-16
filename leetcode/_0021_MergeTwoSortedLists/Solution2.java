package leetcode._0021_MergeTwoSortedLists;
import leetcode.ListNode;

// CRUD no dummy
public class Solution2 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // l1和l2必须都不为null否则会null pointer exception
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head, cur;
        if (l1.val <= l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }

        cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else if (l2.val < l1.val) {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        
        cur.next = l1 == null ? l2 : l1;
        return head;
    }
}
