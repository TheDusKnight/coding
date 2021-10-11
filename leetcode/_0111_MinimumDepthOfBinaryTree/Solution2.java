package leetcode._0111_MinimumDepthOfBinaryTree;

import leetcode.TreeNode;

// 按照题意dfs
class Solution2 {
    int minDepth = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        dfs(root, 0);
        return minDepth;
    }
    
    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            minDepth = Math.min(minDepth, depth);
            return;
        }
        
        depth++;
        if (root.left != null && root.right != null) {
            dfs(root.left, depth);
            dfs(root.right, depth);
        } else if (root.left != null) {
            dfs(root.left, depth);
        } else {
            dfs(root.right, depth);
        }
    }
}
