package leetcode._0110_BalancedBinaryTree;
import leetcode.TreeNode;

// 自上而下dfs方法, 时间复杂度高
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        
        if (Math.abs(leftHeight - rightHeight) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
// time: O(n*log(n))