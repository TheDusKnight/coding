package leetcode._0112_PathSum;

import leetcode.TreeNode;

// 这道题如果用recursion做要返回一个list
// 最好dfs
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        // base case 或者没到leaf node的情况
        if (root == null)
            return false;
        
        // 注意在这里因为不需要在上一层使用当前层的sum，所以不需要keep global variable sum
        sum -= root.val;
        // 真正到leaf node的时候check sum
        if ((root.left == null) && (root.right == null))
            return (sum == 0);
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
