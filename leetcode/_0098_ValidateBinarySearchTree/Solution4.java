package leetcode._0098_ValidateBinarySearchTree;

import java.util.ArrayList;
import java.util.List;

import leetcode.TreeNode;

public class Solution4 {
    // inorder traversal list 最差做法空间复杂度高
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return false;
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        
        for (int i = 1; i < res.size(); i++) {
            if (res.get(i-1).intValue() >= res.get(i).intValue())
                return false;
        }
        return true;
    }
    
    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null)
            return;

        dfs(root.left, res);
        res.add(root.val);
        dfs(root.right, res);
    }
}
