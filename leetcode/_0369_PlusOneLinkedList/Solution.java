package leetcode._0369_PlusOneLinkedList;
import leetcode.ListNode;

// recursion
class Solution {
    public ListNode plusOne(ListNode head) {
        // 最后结果没有进位
        if (dfs(head) == 0) return head;
        // 最后结果进位
        else {
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            return newHead;
        }
    }
    
    private int dfs(ListNode head) {
        // add one to the last node
        if (head == null) return 1;
        
        int carry = dfs(head.next);
        // 如果carry等于0，什么都不用做
        if (carry == 0) return 0;
        // carry等于1，当前node加1后判断是否需要进位
        int value = head.val + carry;
        head.val = value % 10;
        return value / 10;
    }
}
