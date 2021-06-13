package leetcode._0098_ValidateBinarySearchTree;
import leetcode.TreeNode;

public class Solution2 {
    // dfs top down
    // use min max to carry on bound information
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return false;
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean dfs(TreeNode root, long min, long max) {
        if (root == null)
            return true;
        
        if (root.val >= max || root.val <= min)
            return false;
        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }
}