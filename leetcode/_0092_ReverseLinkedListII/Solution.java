package leetcode._0092_ReverseLinkedListII;
import leetcode.ListNode;

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode pre1 = dummy, cur1 = head; // 注意cur1一开始的position就是0
        for (int i = 0; i < m - 1; i++) {
            pre1 = cur1;
            cur1 = cur1.next; // i等于0时，cur1 position就是1了
        }
        pre1.next = null; // 断开
        
        ListNode pre2 = cur1, cur2 = cur1.next;
        for (int i = 0; i < n - m; i++) {
            pre2 = cur2;
            cur2 = cur2.next;
        }
        pre2.next = null; // 断开
        
        ListNode temp = reverseLinkedList(cur1);
        
        pre1.next = temp; // 连接，或者pre1.next = pre2也行
        cur1.next = cur2; // 连接
        
        return dummy.next;
        
    }
    
    private ListNode reverseLinkedList(ListNode head) {
        ListNode pre = null, curr = head, post = null;
        
        while (curr != null) {
            post = curr.next;
            curr.next = pre;
            pre = curr;
            curr = post;
        }
        
        return pre;
    }
}