package leetcode._0098_ValidateBinarySearchTree;
import leetcode.TreeNode;

// use min max to carry on bound information
// top down dfs
public class Solution2 {
    public boolean isBST(TreeNode root) {
        // cc
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(TreeNode root, int lowerBound, int upperBound) {
        // base case
        if (root == null) return true;

        if (root.val >= upperBound || root.val <= lowerBound) return false;
        return isBST(root.left, lowerBound, root.val) && isBST(root.right, root.val, upperBound);
    }
}