package leetcode._0109_ConvertSortedListToBinarySearchTree;
import leetcode.TreeNode;
import leetcode.ListNode;

// recursion
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;

        return constructBST(0, checkLength(head)-1, head);
    }

    private int checkLength(ListNode head) {
        if (head == null) return 0;
        return checkLength(head.next) + 1;
    }

    private TreeNode constructBST(int start, int end, ListNode head) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;
        ListNode tmp = head;

        // 找到mid对应的root
        for (int i = 0; i < mid; i++) {
            tmp = tmp.next;
        }

        TreeNode root = new TreeNode(tmp.val);
        root.left = constructBST(start, mid-1, head);
        root.right = constructBST(mid+1, end, head);
        return root;
    }
}

// time: O(n^2)
