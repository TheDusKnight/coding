package leetcode._1644_LowestCommonAncestorOfABinaryTreeII;

import leetcode.TreeNode;

// only traverse once
// 和LCA逻辑一样，只是必定遍历整棵树，最后查看count是否等于2
class Solution2 {
    int count = 0;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // cc
        
        TreeNode res = recursion(root, p, q);
        if (count != 2) return null;
        return res;
    }
    
    private TreeNode recursion(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        
        TreeNode left = recursion(root.left, p, q);
        TreeNode right = recursion(root.right, p, q);
        
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
