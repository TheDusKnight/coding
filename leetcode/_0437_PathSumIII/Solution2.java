package leetcode._0437_PathSumIII;

import leetcode.TreeNode;

// dfs
class Solution2 {
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        
        dfs(root, targetSum);
        
        return count;
    }
    
    private void dfs(TreeNode root, int targetSum) {
        if (root == null) return;
        
        findTarget(root, targetSum);
        
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
    }
    
    private void findTarget(TreeNode root, int targetSum) {
        if (root == null) return;
        
        targetSum -= root.val;
        if (targetSum == 0) { // 等于0还要继续找,因为有负数
            count++;
        }
        
        findTarget(root.left, targetSum);
        findTarget(root.right, targetSum);
    }
}

// time: O(N^2); space:O(1);
