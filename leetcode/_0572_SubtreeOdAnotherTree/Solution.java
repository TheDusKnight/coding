package leetcode._0572_SubtreeOdAnotherTree;
import leetcode.TreeNode;

class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false; // s触底没有找到
        if (isSameTree(s, t)) return true; // 当前s找到
        return isSubtree(s.left, t) || isSubtree(s.right, t); // s往左找往右找
    }
    
    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
