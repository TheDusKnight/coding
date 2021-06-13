package leetcode._0094_BinaryTreeInorderTraversal;
import java.util.ArrayList;
import java.util.List;

import leetcode.TreeNode;

public class Solution {
    // dfs recursion
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        dfs(root, res);
        return res;
    }
    
    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        
        dfs(root.left, res);
        res.add(root.val);
        dfs(root.right, res);
    }
    
    // time: O(n)
}
