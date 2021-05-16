package leetcode._0141_LinkedListCycle;
import java.util.*;
import leetcode.ListNode;

// hashset
public class Solution2 {
    public boolean hasCycle(ListNode head) {
        // cc
        if (head == null) return false;
        
        Set<ListNode> nodeSeen = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (nodeSeen.contains(cur)) return true;
            else nodeSeen.add(cur);
            cur = cur.next;
        }
        return false;
    }
}