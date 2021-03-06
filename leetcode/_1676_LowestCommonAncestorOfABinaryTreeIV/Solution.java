package leetcode._1676_LowestCommonAncestorOfABinaryTreeIV;

import leetcode.TreeNode;

// node为多个
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        if (root == null) return root;
        for (TreeNode node: nodes) {
            if (root == node) return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, nodes);
        TreeNode right = lowestCommonAncestor(root.right, nodes);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        } else {
            return null;
        }
    }
}
