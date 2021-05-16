package leetcode._0144_BinaryTreePreorderTraversal;
import java.util.*;
import leetcode.TreeNode;

// recursion
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }
    private void helper(TreeNode root, List<Integer> list) {
        if (root == null) return;
        
        list.add(root.val);
        helper(root.left, list);
        helper(root.right, list);
    }
}

