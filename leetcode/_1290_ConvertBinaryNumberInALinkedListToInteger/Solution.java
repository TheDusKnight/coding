package leetcode._1290_ConvertBinaryNumberInALinkedListToInteger;

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

// recursion
class Solution {
    int i = 0;
    public int getDecimalValue(ListNode head) {
        if (head == null) return 0;
        
        int preRes = getDecimalValue(head.next);
        return preRes + (int)Math.pow(2, i++)*head.val;
    }
}

// time: O(N); space: O(N);
