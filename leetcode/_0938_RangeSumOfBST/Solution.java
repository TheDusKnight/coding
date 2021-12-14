package leetcode._0938_RangeSumOfBST;

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
// bst
class Solution {
    int sum, low, high;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) throw new IllegalArgumentException();
        
        sum = 0; this.low = low; this.high = high;
        inorder(root);
        
        return sum;
    }
    
    private void inorder(TreeNode cur) {
        if (cur == null) return;
        
        inorder(cur.left);
        if (cur.val >= low && cur.val <= high) sum += cur.val;
        if (cur.val > high) return;
        inorder(cur.right);
    }
}

// time: most of the time better than O(N); space: O(N);
