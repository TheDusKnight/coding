package leetcode._0108_ConvertSortedArrayToBinarySearchTree;

import leetcode.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// dfs + bst + divide and conquer; 因为是dfs二分所以所有左右子树高度差永远不会大于1
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) return null;
        
        return formBST(nums, 0, nums.length-1);
    }
    
    private TreeNode formBST(int[] nums, int start, int end) {
        if (start > end) return null; // 错加了等于号，等于的时候也要生成node
        
        int mid = start + (end - start) / 2;
        TreeNode cur = new TreeNode(nums[mid]);
        cur.left = formBST(nums, start, mid-1);
        cur.right = formBST(nums, mid+1, end);
        return cur;
    }
}

// time: O(n); space: O(n). O(n) to keep the output, and O(log*n) for the recursion stack;
