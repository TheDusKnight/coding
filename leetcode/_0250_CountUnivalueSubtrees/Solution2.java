package leetcode._0250_CountUnivalueSubtrees;

import leetcode.TreeNode;

// dfs brute force
class Solution2 {
    int count;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        
        count = 0;
        dfs(root);
        return count;
    }
    
    private void dfs(TreeNode root) {
        if (root == null) return;
        
        if (eval(root, root.val)) count++;
        dfs(root.left);
        dfs(root.right);
    }
    
    private boolean eval(TreeNode root, int val) {
        if (root == null) return true;
        
        if (root.val != val) return false;
        
        boolean left = eval(root.left, val);
        boolean right = eval(root.right, val);
        return (left && right);
    }
}

// time: O(n^2); space: O(1);
