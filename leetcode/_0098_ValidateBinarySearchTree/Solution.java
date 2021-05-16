package leetcode._0098_ValidateBinarySearchTree;
import leetcode.TreeNode;

// Use definition of inorder traverse, curr value always bigger than previous value
// inorder: 左根右
public class Solution {
    private Integer prev;

    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }

    private boolean inorder(TreeNode root) {
        // corner case
        if (root == null) return true;
        
        // left
        if (!inorder(root.left)) return false;
        // root
        if (prev != null && root.val <= prev) return false;
        prev = root.val;
        // right
        return inorder(root.right);
    }
}
