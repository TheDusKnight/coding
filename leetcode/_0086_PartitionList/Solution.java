package leetcode._0086_PartitionList;
import leetcode.ListNode;

// 加强版的 LC328 Odd even linked list
class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        
        ListNode dummySmall = new ListNode();
        ListNode dummyLarge = new ListNode();
        ListNode small = dummySmall;
        ListNode large = dummyLarge;
        
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null; // 防止成环，因为large后面有可能是small node
        small.next = dummyLarge.next;
        return dummySmall.next;
    }
}
