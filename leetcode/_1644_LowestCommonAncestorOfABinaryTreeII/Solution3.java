package leetcode._1644_LowestCommonAncestorOfABinaryTreeII;

import leetcode.TreeNode;

// recursion时间复杂度高
class Solution3 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // cc
        
        TreeNode[] res = lca(root, p, q);
        if (res[0] != null && res[1] != null) {
            return res[0];
        } else {
            return null;
        }
    }
    
    private TreeNode[] lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return new TreeNode[2];
        
        TreeNode[] left = lca(root.left, p, q);
        if (left[0] != null && left[1] != null) return left;
        TreeNode[] right = lca(root.right, p, q);
        if (right[0] != null && right[1] != null) return right;
        
        TreeNode[] res = new TreeNode[2];
        if (root == p || left[0] == p || right[0] == p) res[0] = p;
        if (root == q || left[1] == q || right[1] == q) res[1] = q;
        if (res[0] == p && res[1] == q) {
            res[0] = root;
            res[1] = root;
        }
        
        return res;
    }
}