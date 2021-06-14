package leetcode._0298_BinaryTreeLongestConsecutiveSequence;

import leetcode.TreeNode;

public class Solution {
    // dfs recursion
    // private int max = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null)
            return 0;
        int[] max = new int[]{0};
        dfs(root, max);
        return max[0];
    }
    
    private int dfs(TreeNode root, int[] max) {
        if (root == null)
            return 0;
        
        int lLen = dfs(root.left, max);
        int rLen = dfs(root.right, max);
        int localLen = 1; // 初始化为1，最少为连续为自己
        // check子树是否连续
        if (root.left != null && root.val+1 == root.left.val) {
            localLen = lLen + 1;
        }
        if (root.right != null && root.val+1 == root.right.val) {
            localLen = Math.max(localLen, rLen + 1);
        }
        max[0] = Math.max(max[0], localLen);
        return localLen;
    }
}

// time: O(n)
