package leetcode._0021_MergeTwoSortedLists;
import leetcode.ListNode;

// recursion
class Solution3 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        if (l1.val <= l2.val) { // 谁小return谁
            // 当前的node就用l1，l1之后的值是什么往下问
            l1.next = mergeTwoLists(l1.next, l2);
            // return的时候保证l1后面，以及l1本身都是sorted的
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}

// time: O(n+m);