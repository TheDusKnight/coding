package leetcode._0876_MiddleOfTheLinkedList;
import leetcode.ListNode;

// consistent with array middle point
// slow fast 指针三种解法
// S1: check fast.next.next
// s2: dummy node fast.next
// s3: ListNode fast = head.next; fast.next

class Solution2 {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
