package leetcode._0160_IntersectionOfTwoLinkedLists;
import leetcode.ListNode;

// Math. A走完走B。B走完走A，相遇一定是intersection。 A+C+B = B+C+A
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // cc
        
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
        // Note: In the case lists do not intersect, the pointers for A and B
        // will still line up in the 2nd iteration, just that here won't be
        // a common node down the list and both will reach their respective ends
        // at the same time. So pA will be NULL in that case.
        // 没有intersection的时候pA和pB会同时到达null
    }
}

// O(A + B + C)