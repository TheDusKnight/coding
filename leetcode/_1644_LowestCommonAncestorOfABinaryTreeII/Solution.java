package leetcode._1644_LowestCommonAncestorOfABinaryTreeII;

import leetcode.TreeNode;

// p and/or q may not exist
class Solution {
    int num = 0;
    TreeNode p;
    TreeNode q;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        checkNode(root, p, q);
        if (num != 2) return null;
        
        this.p = p;
        this.q = q;
        return lowestCommonAncestor(root);
    }
    
    private TreeNode lowestCommonAncestor(TreeNode root) {
        if (root == null || root == p || root == q) return root;
        
        TreeNode left = lowestCommonAncestor(root.left);
        TreeNode right = lowestCommonAncestor(root.right);
        if (left != null && right != null) return root;
        if (left != null) return left;
        if (right != null) return right;
        return null;
    }
    
    private void checkNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return;
        
        if (root == p || root == q) num++;
        checkNode(root.left, p, q);
        checkNode(root.right, p, q);
    }
}

// time: O(2N); space: O(log(N) ~ N);
