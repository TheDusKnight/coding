package leetcode._0124_BinaryTreeMaximumPathSum;
import leetcode.TreeNode;

// recursion leave node to any node加剪枝，在每个node拼接并更新max path
class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        recursion(root);
        return max;
    }
    
    private int recursion(TreeNode root) {
        if (root == null) return 0;
        
        int left = recursion(root.left);
        int right = recursion(root.right);
        if (left < 0) left = 0;
        if (right < 0) right = 0;
        max = Math.max(max, left + right + root.val);
        // 返回并不是max path，而是一条路径的max height
        return Math.max(left, right) + root.val;
    }
}

// time: O(N); space: O(1)