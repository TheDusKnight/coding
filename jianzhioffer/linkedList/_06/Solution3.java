package jianzhioffer.linkedList._06;
import java.util.Stack;

// stack
public class Solution3 {
    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[] {};
        if (head.next == null) return new int[] {head.val};

        Stack<ListNode> stack = new Stack<>();
        ListNode tmp = head;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
        }
        int size = stack.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = stack.pop().val;
        }
        return res;
    }
}

// time: O(n); space: O(n);
