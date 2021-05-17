package leetcode._0144_BinaryTreePreorderTraversal;
import java.util.ArrayList;
import java.util.List;

import leetcode.TreeNode;

// dfs
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }
    
    private void dfs(TreeNode root, List<Integer> list) {
        // cc + end
        if (root == null) return;
        
        list.add(root.val);
        dfs(root.left, list);
        dfs(root.right, list);
    }
}
