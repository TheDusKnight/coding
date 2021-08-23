package leetcode._0328_OddEvenLinkedList;
import leetcode.ListNode;

// tech bow
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        
        ListNode odd = head, even = head.next, evenHead = even;
        
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}

// time: O(n)
// space: O(1)
