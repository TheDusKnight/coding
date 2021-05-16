package leetcode._0083_Remove_duplicatesFromSortedList;
import leetcode.ListNode;

// CRUD
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // cc
        if (head == null || head.next == null) return head;

        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                ListNode tmp = cur.next.next;
                cur.next.next = null;
                cur.next = tmp;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
