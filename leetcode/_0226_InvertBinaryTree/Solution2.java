package leetcode._0226_InvertBinaryTree;
import leetcode.TreeNode;

// top down
class Solution {
    public TreeNode invertTree(TreeNode root) {
        // cc
        if (root == null) return null;
        
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
