package leetcode._0298_BinaryTreeLongestConsecutiveSequence;

import leetcode.TreeNode;

// dfs
class Solution3 {
    int longest = Integer.MIN_VALUE;
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        
        dfs(root, 1, Integer.MIN_VALUE); // Integer.MIN_VALUE需要讨论
        return longest;
    }
    
    private void dfs(TreeNode root, int count, int parentVal) {
        if (root == null) return;
        
        if (parentVal + 1 == root.val) count++;
        else count = 1;
        longest = Math.max(longest, count);
        parentVal = root.val;
        
        dfs(root.left, count, parentVal);
        dfs(root.right, count, parentVal);
    }
}
