package leetcode._0203_RemoveLinkedListElements;
import leetcode.ListNode;

// CRUD
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // cc
        if (head == null) return null;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur != null && cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
