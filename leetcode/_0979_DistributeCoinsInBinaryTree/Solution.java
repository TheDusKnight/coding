package leetcode._0979_DistributeCoinsInBinaryTree;

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
class Solution {
    int res = 0;
    public int distributeCoins(TreeNode root) {
        if (root == null) return 0;
        
        recursion(root);
        
        return res;
    }
    
    private int recursion(TreeNode cur) {
        if (cur == null) return 0;
        
        int left = recursion(cur.left);
        int right = recursion(cur.right);
        
        res += Math.abs(left) + Math.abs(right);
        return cur.val + left + right - 1; // 当前子树溢出部分
    }
}

// time: O(N); space: O(N);
