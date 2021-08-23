package leetcode._0086_PartitionList;

import leetcode.ListNode;

// 无dummy node解法
class Solution2 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        
        ListNode small = null, big = null, cur = head;
        ListNode dummySmall = null, dummyBig = null;
        
        while (cur != null) {
            if (cur.val < x) {
                if (small == null) {
                    small = cur;
                    dummySmall = small;
                }
                else {
                    small.next = cur;
                    small = small.next;
                }
            } else {
                if (big == null) {
                    big = cur;
                    dummyBig = big;
                }
                else {
                    big.next = cur;
                    big = big.next;
                }
            }
            cur = cur.next;
        }
        
        if (small == null || big == null) return head;
        
        big.next = null;
        small.next = dummyBig;
        return dummySmall;
    }
}
