package leetcode._1120_MaximumAverageSubtree;

import leetcode.TreeNode;

// 老刘mock原题
class Solution {
    double avg;
    public double maximumAverageSubtree(TreeNode root) {
        if (root == null) return 0;
        
        avg = 0.0;
        dfs(root);
        return avg;
    }
    
    private int[] dfs(TreeNode root) {
        if (root == null) return new int[] {0, 0};
        
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        
        int sum = l[0] + r[0] + root.val;
        int num = l[1] + r[1] + 1;
        
        avg = Math.max(avg, (double)sum / num);
        
        return new int[] {sum, num};
    }
}

// time: O(N); space: O(N);
// recursion
