package leetcode._0230_KthSmallestElementInABST;

import leetcode.TreeNode;

// dfs inorder
class Solution {
    int count;
    int find;
    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        find = -1;
        inOrder(root, k);
        return find;
    }
    
    private void inOrder(TreeNode root, int k) {
        if (root == null) return;
        
        inOrder(root.left, k);
        count++;
        if (count == k) find = root.val;
        inOrder(root.right, k);
    }
}

// time: O(N); space: O(N);
