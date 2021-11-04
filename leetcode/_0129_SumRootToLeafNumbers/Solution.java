package leetcode._0129_SumRootToLeafNumbers;

import leetcode.TreeNode;

// tree dfs
class Solution {
    int sum;
    public int sumNumbers(TreeNode root) {
        // cc
        
        sum = 0;
        dfs(root, 0);
        return sum;
    }
    
    private void dfs(TreeNode root, int curSum) {
        if (root == null) {
            // sum += curSum;
            return;
        }
        
        curSum = curSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += curSum;
        }
        dfs(root.left, curSum);
        dfs(root.right, curSum);
    }
}
