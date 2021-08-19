package leetcode._1644_LowestCommonAncestorOfABinaryTreeII;

import leetcode.TreeNode;

// only traverse once
class Solution2 {
    int count = 0;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // cc
        
        TreeNode res = dfs(root, p, q);
        if (count != 2) return null;
        return res;
    }
    
    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        
        TreeNode left = dfs(root.left, p, q);
        TreeNode right = dfs(root.right, p, q);
        
        if (root == p || root == q) { // bottom up
            count++;
            return root;
        }
        
        if (left != null && right != null) return root;
        if (left != null) return left;
        if (right != null) return right;
        return null;
        // return left == null ? right : right == null ? left : root;
    }
}

// time: O(N); space: O(log(N) ~ N);
