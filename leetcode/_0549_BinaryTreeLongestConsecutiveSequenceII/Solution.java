package leetcode._0549_BinaryTreeLongestConsecutiveSequenceII;

import leetcode.TreeNode;

public class Solution {
    // dfs recursion
    private int max = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root);
        return max;
    }
    
    private int[] dfs(TreeNode root) {
        if (root == null)
            return new int[]{0, 0};
        // post order就是dfs recursion
        int[] lLen = dfs(root.left);
        int[] rLen = dfs(root.right);
        // 返回两个值表示最长decrease和increase序列是多少，初始化为1包含自己
        int[] localLen = new int[]{1, 1};
        if (root.left != null) {
            if (root.val == root.left.val + 1) { // decrease
                localLen[0] = lLen[0] + 1;
            } else if (root.val + 1 == root.left.val) { // increase
                localLen[1] = lLen[1] + 1;
            }
        }
        if (root.right != null) {
            if (root.val == root.right.val + 1) {
                // 如果左右都是decrease取最大
                localLen[0] = Math.max(localLen[0], rLen[0] + 1);
            } else if (root.val + 1 == root.right.val) {
                // 如果左右都是increase取最大
                localLen[1] = Math.max(localLen[1], rLen[1] + 1);
            }
        }
        max = Math.max(max, localLen[0] + localLen[1] - 1); // root多算了一次
        return localLen;
    }
}

// time: O(n) 每个点摸一次