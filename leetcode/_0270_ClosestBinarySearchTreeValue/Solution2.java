package leetcode._0270_ClosestBinarySearchTreeValue;

import leetcode.TreeNode;

public class Solution2 {
    // dfs + tree inorder
    double closest = Integer.MAX_VALUE;
    int res = -1;
    public int closestValue(TreeNode root, double target) {
        // cc
        dfs(root, target);
        return res;
    }
    
    private void dfs(TreeNode root, double target) {
        // 答案不出在leaf node所以不能从尾巴返回值
        if (root == null) {
            return;
        }
        dfs(root.left, target);
        if (Math.abs(root.val - target) < closest) {
            closest = Math.abs(root.val - target);
            res = root.val;
        }
        dfs(root.right, target);
    }
}

// time: O(n)
