package leetcode._0222_CountCompleteTreeNodes;

import leetcode.TreeNode;

public class Solution {
    // Dfs recursion 只走一边
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        
        int hL = getHeight(root.left);
        int hR = getHeight(root.right);
        if (hL == hR + 1) { // right is full
            return countNodes(root.left) + 1 + (int)Math.pow(2, hR)-1;
        } else if (hL == hR) { // left is full
            return countNodes(root.right) + 1 + (int)Math.pow(2, hL)-1;
        } else {
            throw new IllegalArgumentException("Invalid complete binary tree");
        }
    }

    private int getHeight(TreeNode root) { // O(log(n))
        int count = 0;
        while (root != null) {
            count++;
            root = root.left;
        }
        return count;
    }
}

// time: O(log(n)*log(n));