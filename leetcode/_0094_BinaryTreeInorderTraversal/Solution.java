package leetcode._0094_BinaryTreeInorderTraversal;
import java.util.*;
import leetcode.TreeNode;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }
    
    private void helper(TreeNode root, List<Integer> list) {
        if (root == null) return;
        
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }
}
