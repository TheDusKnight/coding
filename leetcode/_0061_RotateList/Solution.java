package leetcode._0061_RotateList;

import leetcode.ListNode;

// slow fast + two pass
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        if (k <= 0) return head; // k为0什么都不变
        
        ListNode p = head;
        int n = 1; // 计算ListNode的长度
        while (p != null && p.next != null) {
            p = p.next;
            n++;
        }
        
        k = k >= n ? k % n : k; // 处理k
        if (k <= 0) return head; // 注意别忘了post check
        
        ListNode slow = head, fast = head;
        while (k-- > 0) {
            fast = fast.next;
        }
        
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        
        return newHead;
    }
}

// time: O(2N)