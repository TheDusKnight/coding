package leetcode._0111_MinimumDepthOfBinaryTree;
import leetcode.TreeNode;

// recursion
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (root.left == null || root.right == null) return left + right + 1;
        return Math.min(left, right) + 1;
    }
}
