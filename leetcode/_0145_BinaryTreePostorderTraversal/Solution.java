package leetcode._0145_BinaryTreePostorderTraversal;
import java.util.*;
import leetcode.TreeNode;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }
    
    private void helper(TreeNode root, List<Integer> list) {
        if (root == null) return;
        
        helper(root.left, list);
        helper(root.right, list);
        list.add(root.val);
    }
}
