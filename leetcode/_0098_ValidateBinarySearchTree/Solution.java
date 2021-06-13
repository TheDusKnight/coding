package leetcode._0098_ValidateBinarySearchTree;
import leetcode.TreeNode;

// Use definition of inorder traverse, curr value always bigger than previous value
// inorder: 左根右
public class Solution {
    // dfs maintain prev inorder
    // inorder traversal list 的优化
    Integer prev;
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return false;
        return dfs(root);
    }
    
    private boolean dfs(TreeNode root) {
        if (root == null)
            return true;
        
        if (!dfs(root.left))
            return false;
        if (prev != null && prev >= root.val)
            return false;
        prev = root.val;
        // 左和根都check过了，check右返回什么就是什么
        if (!dfs(root.right))
            return false;
        return true;
    }
}

// time: O(n)
