package leetcode._0110_BalancedBinaryTree;
import leetcode.TreeNode;

// 自下而上recusion
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        
        return helper(root) == -1 ? false : true;
    }
    
    private int helper (TreeNode root) {
        if (root == null) return 0;
        
        int leftHeight = helper(root.left);
        int rightHeight = helper(root.right);
        
        // 阻断, 如果left或者right有一个是-1那么以最快速度返回-1；
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        return Math.max(leftHeight, rightHeight)+1;
    }
}
