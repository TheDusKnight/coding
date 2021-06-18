package leetcode._0270_ClosestBinarySearchTreeValue;

import leetcode.TreeNode;

public class Solution3 {
    // bst + dfs top down then bottom up
    public int closestValue(TreeNode root, double target) {
        // cc
        return dfs(root, target, root.val);
    }
    
    private int dfs(TreeNode root, double target, int closest) {
        // 答案出在leaf node可以从尾巴返回值
        if (root == null)
            return closest;
        
        if (Math.abs(root.val - target) < Math.abs(closest - target)) {
            closest = root.val;
        }
        if (root.val < target) {
            closest = dfs(root.right, target, closest);
        } else {
            closest = dfs(root.left, target, closest);
        }
        return closest;
    }
}

// time: O(log(n))
