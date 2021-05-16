package leetcode._0160_IntersectionOfTwoLinkedLists;
import leetcode.ListNode;
import java.util.Set;
import java.util.HashSet;

// hashmap
public class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        
        while (headB != null) {
            if (set.contains(headB)) return headB;
            headB = headB.next;
        }
        
        return null;
    }
}