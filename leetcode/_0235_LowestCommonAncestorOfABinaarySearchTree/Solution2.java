package leetcode._0235_LowestCommonAncestorOfABinaarySearchTree;
import leetcode.TreeNode;

// 因为只有一条路径，所以不需要stack或者recursion
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        
        int parentVal;
        int pVal = p.val;
        int qVal = q.val;
        TreeNode node = root;
        while (node != null) {
            parentVal = node.val;
            if (parentVal > pVal && parentVal > qVal) {
                node = node.left;
            } else if (parentVal < pVal && parentVal < qVal) {
                node = node.right;
            } else {
                return node;
            }
        }
        return node;
    }
}
