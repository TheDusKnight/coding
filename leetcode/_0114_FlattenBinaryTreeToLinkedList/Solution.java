package leetcode._0114_FlattenBinaryTreeToLinkedList;
import leetcode.TreeNode;

// Similar LC426
// recursion，pre-order is root, left, right, so recursion is right, left, root to find the last element
class Solution {
    TreeNode pre;
    public void flatten(TreeNode root) {
        if (root == null) return;
        
        flatten(root.right);
        flatten(root.left);
        
        root.left = null;
        root.right = pre;
        pre = root;
    }
}
