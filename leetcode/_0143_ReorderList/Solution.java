package leetcode._0143_ReorderList;
import leetcode.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// 非常经典的一道题，结合的很多linkedlist的知识点
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        
        ListNode mid = findMid(head);
        ListNode left = head;
        ListNode right = mid.next;
        
        mid.next = null;
        merge(left, reverse(right));
    }
    
    // 考虑奇偶性，这里如果偶数，mid取靠左边
    private ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
//     private ListNode reverse(ListNode head) {
//         if (head == null || head.next == null) return head;
        
//         ListNode newHead = reverse(head.next);
//         head.next.next = head;
//         head.next = null;
//         return newHead;
//     }
    
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
    
    private void merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        
        while (left != null && right != null) {
            cur.next = left;
            left = left.next;
            cur = cur.next;
            
            cur.next = right;
            right = right.next;
            cur = cur.next;
        }
        
        cur.next = left;
    }
}

// time: O(0)
// space: O(1)