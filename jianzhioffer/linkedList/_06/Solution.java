package jianzhioffer.linkedList._06;

/**
 * 从尾到头打印链表
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

// iteration
class Solution {
    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[] {};
        if (head.next == null) return new int[] {head.val};

        ListNode prev = null, cur = head;
        ListNode temp = null;
        int size = 0;
        while (cur != null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
            size++;
        }
        
        ListNode tmp = prev;
        int[] res = new int[size];
        for (int i = 0; i < res.length; i++) {
            res[i] = tmp.val;
            tmp = tmp.next;
        }
        
        return res;
    }
}

// time: O(n); space: O(n) 如果算上res;
