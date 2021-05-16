package jianzhioffer.linkedList._06;

// recursion
class Solution2 {
    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[] {};
        if (head.next == null) return new int[] {head.val};

        int[] size = new int[] {0};
        ListNode newHead = reverseList(head, size);

        int[] res = new int[size[0]];
        for (int i = 0; i < size[0]; i++) {
            res[i] = newHead.val;
            newHead = newHead.next;
        }

        return res;
    }
    
    public ListNode reverseList(ListNode head, int[] size) {
        size[0]++;
        if (head == null || head.next == null) return head;

        ListNode newHead = reverseList(head.next, size);
        // wall
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}

// time: O(n); space: O(n);
