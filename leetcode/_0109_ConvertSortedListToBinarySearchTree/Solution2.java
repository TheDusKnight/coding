package leetcode._0109_ConvertSortedListToBinarySearchTree;
import java.util.*;
import leetcode.TreeNode;
import leetcode.ListNode;

// recursion ListNode convert to array
public class Solution2 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;

        List<Integer> list = new ArrayList<>();
        int len = getLength(head, list);

        return constructBST(0, len-1, list);
    }

    private TreeNode constructBST(int start, int end, List<Integer> list) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = constructBST(start, mid-1, list);
        root.right = constructBST(mid+1, end, list);
        return root;
    }

    private int getLength(ListNode head, List<Integer> list) {
        if (head == null) return 0;
        list.add(head.val);
        return getLength(head.next, list)+1;
    }
}
