package leetcode._0111_MinimumDepthOfBinaryTree;
import leetcode.TreeNode;

class Solution {
    // 自写
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        if (root.left != null && root.right == null) {
            return minDepth(root.left) + 1;
        } else if (root.left == null && root.right != null) {
            return minDepth(root.right) + 1;
        } else {
            int leftHeight = minDepth(root.left);
            int rightHeight = minDepth(root.right);
            return Math.min(leftHeight, rightHeight) + 1;
        }
    }
    // 老刘
    // public int minDepth(TreeNode root) {
    //     if (root == null) return 0;
        
    //     int left = minDepth(root.left);
    //     int right = minDepth(root.right);
    //     if (left == 0 || right == 0) return left + right + 1;
    //     return Math.min(left, right)+1;
    // }
}
