package leetcode._0108_ConvertSortedArrayToBinarySearchTree;
import leetcode.TreeNode;

// 老刘说是recursion bottom up
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        return constructBST(0, nums.length-1, nums);
    }

    private TreeNode constructBST(int start, int end, int[] nums) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;
        TreeNode cur = new TreeNode(nums[mid]);

        cur.left = constructBST(start, mid-1, nums);
        cur.right = constructBST(mid+1, end, nums);
        return cur;
    }
}

// time: O(n)
// space: O(n)