package leetcode._0021_MergeTwoSortedLists;
import leetcode.ListNode;

// LC148 Sort list的弱化版
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        
        ListNode dummy = new ListNode();
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
        return dummy.next;
    }
}
