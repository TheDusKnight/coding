package leetcode._0114_FlattenBinaryTreeToLinkedList;
import leetcode.TreeNode;

// Similar LC426
// recursion，需要单独记忆
public class Solution {
    TreeNode pre;
    public void flatten (TreeNode root) {
        if (root == null) return;
        helper(root);
    }
    private void helper (TreeNode node) {
        if (node == null) return;

        flatten(node.right);
        flatten(node.left);
        
        node.right = pre;
        node.left = null;
        // pre++
        pre = node;
    }
}
