package leetcode._0543_DiameterOfBinaryTree;

import leetcode.TreeNode;

class Solution {
    int longest = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return longest;
    }
    
    private int dfs(TreeNode cur) {
        if (cur == null) return 0;
        
        int lLen = dfs(cur.left);
        int rLen = dfs(cur.right);
        longest = Math.max(longest, lLen + rLen);
        return Math.max(lLen, rLen) + 1;
    }
}

// time: O(N). N is the number of nodes;
