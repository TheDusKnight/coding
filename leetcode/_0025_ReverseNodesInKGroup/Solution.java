package leetcode._0025_ReverseNodesInKGroup;
import leetcode.ListNode;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        // 检验该区间是否符合k-group
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            if (cur == null) return head; // 注意先check
            cur = cur.next;
        }

        // 如果没有return，那么现在已经前进k个node;
        ListNode preHead = reverseKGroup(cur, k);
        // wall
        // reverse linked list by one iteration
        ListNode prev = preHead; // 这里pre初始化为preHead
        ListNode curr = head;
        ListNode temp = null;

        // 表示把k个元素的区间反转，不能用while loop
        for (int i = 0; i < k; i++) { 
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev; // 返回当前的头节点
    }
}
