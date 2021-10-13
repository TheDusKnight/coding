package leetcode._0109_ConvertSortedListToBinarySearchTree;

import leetcode.ListNode;
import leetcode.TreeNode;

// 使用快慢针找中点逻辑和108一样
class Solution4 {
    public TreeNode sortedListToBST(ListNode head) {
        return constructBST(head);
    }
    
    private TreeNode constructBST(ListNode head) {
        if (head == null) return null;
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy, fast = dummy, pre = dummy;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        
        TreeNode root = new TreeNode(slow.val);
        root.left = constructBST(dummy.next);
        root.right = constructBST(slow.next);
        
        return root;
    }
}
