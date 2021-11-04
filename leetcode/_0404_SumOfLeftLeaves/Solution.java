package leetcode._0404_SumOfLeftLeaves;

import leetcode.TreeNode;

// dfs
class Solution {
    int leftSum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        // cc
        
        dfs(root, false);
        
        return leftSum;
    }
    
    private void dfs(TreeNode root, boolean isLeft) {
        if (root == null) return;
        
        if (root.left == null && root.right == null && isLeft)
            leftSum += root.val;
        
        dfs(root.left, true);
        dfs(root.right, false);
    }
}

// time: O(N); space: O(1);
