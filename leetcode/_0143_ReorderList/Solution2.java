package leetcode._0143_ReorderList;

import leetcode.ListNode;

// 自写
class Solution2 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        
        ListNode mid = findMid(head);
        mergeTwoList(head, reverse(mid));
    }
    
    private ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head, pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        pre.next = null;
        
        return slow;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head, tmp = null;
        
        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        
        return pre;
    }
    
    private void mergeTwoList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        
        while (l1 != null && l2 != null) {
            cur.next = l1;
            cur = cur.next;
            l1 = l1.next;
            
            cur.next = l2;
            cur = cur.next;
            l2 = l2.next;
        }
        
        // cur.next = l1;
    }
}
