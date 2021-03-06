package leetcode._0083_RemoveDuplicatesFromSortedList;
import leetcode.ListNode;

// CRUD
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) cur.next = cur.next.next;
            else cur = cur.next;
        }
        return head;
    }
}

// time: O(n)
// space: O(1)