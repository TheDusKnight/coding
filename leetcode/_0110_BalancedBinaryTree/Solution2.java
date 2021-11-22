package leetcode._0110_BalancedBinaryTree;
import leetcode.TreeNode;

// recursion
class Solution2 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        
        if (helper(root) == -1) return false;
        return true;
    }
    
    private int helper(TreeNode root) {
        if (root == null) return 0;
        
        int left = helper(root.left);
        if (left == -1) return -1;
        int right = helper(root.right);
        if (right == -1) return -1;
        
        int balance = Math.abs(left - right);
        if (balance > 1) return -1;
        return Math.max(left, right) + 1; // return 当前node到leave的最大高度
    }
}
