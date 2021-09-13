package leetcode._0098_ValidateBinarySearchTree;
import leetcode.TreeNode;

// Use definition of inorder traverse, curr value always bigger than previous value
// inorder: 左根右
class Solution {
    TreeNode pre;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        
        boolean left = isValidBST(root.left);
        if (!left) return false;
        
        if (pre != null && root.val <= pre.val) return false;
        pre = root;
        
        boolean right = isValidBST(root.right);
        return right;
    }
}

// time: O(N); space: O(N);
