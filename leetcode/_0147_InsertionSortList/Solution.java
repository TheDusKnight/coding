package leetcode._0147_InsertionSortList;
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
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode();
        dummy.next = null;
        
        ListNode cur = head;
        
        while (cur != null) {
            // 找到需要插入的位置
            ListNode pre = dummy;
            while (pre != null && pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            
            ListNode next = cur.next;
            // insert the current node to the new list
            cur.next = pre.next;
            pre.next = cur;
            // moving to the next iteration
            cur = next;
        }
        return dummy.next;
    }
}