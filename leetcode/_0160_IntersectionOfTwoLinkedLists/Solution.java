package leetcode._0160_IntersectionOfTwoLinkedLists;
import leetcode.ListNode;

// 数学解，A走完走B。B走完走A，相遇一定是intersection。 A+C+B = B+C+A
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // cc
        if (headA == null || headB == null) return null;
        
        // 注意需要判断没有intersection的情况
        boolean flag1 = false;
        boolean flag2 = false;
        ListNode cur1 = headA, cur2 = headB;
        while (cur1 != cur2) {
            if (cur1 != null) cur1 = cur1.next;
            else {
                if (flag1) return null;
                flag1 = true;
                cur1 = headB;
            }
            if (cur2 != null) cur2 = cur2.next;
            else {
                if (flag2) return null;
                flag2 = true;
                cur2 = headA;
            }
        }
        
        return cur1;
    }
}