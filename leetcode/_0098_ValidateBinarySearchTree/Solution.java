package leetcode._0098_ValidateBinarySearchTree;
import leetcode.TreeNode;

// Use definition of inorder traverse, curr value always bigger than previous value
// inorder: 左根右
class Solution {
    TreeNode pre;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        
        if (!isValidBST(root.left)) return false;
        
        if (pre == null || pre.val < root.val) {
            pre = root;
        } else return false;
        
        return isValidBST(root.right);
    }
}

// time: O(N); space: O(N);
