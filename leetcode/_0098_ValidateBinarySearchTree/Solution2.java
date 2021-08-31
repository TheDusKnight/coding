package leetcode._0098_ValidateBinarySearchTree;
import leetcode.TreeNode;

// dfs top down
class Solution2 {
    // use min max to carry on bound information
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean dfs(TreeNode root, long min, long max) {
        if (root == null) return true;
        
        if (root.val <= min || root.val >= max) return false;
        
        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }
}

// time: O(N); space: (N);