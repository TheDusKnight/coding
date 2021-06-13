package leetcode._0099_RecoverBinarySearchTree;

import leetcode.TreeNode;

public class Solution {
    // dfs recursion inorder
    TreeNode pre;
    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        TreeNode[] swap = new TreeNode[2];
        dfs(root, swap);
        int tmp = swap[0].val;
        swap[0].val = swap[1].val;
        swap[1].val = tmp;
    }
    
    private void dfs(TreeNode root, TreeNode[] swap) {
        if (root == null)
            return;
        
        dfs(root.left, swap);
        if (pre != null && root.val <= pre.val) {
            if (swap[0] == null) {
                swap[0] = pre;
            }
            swap[1] = root;
        }
        pre = root; // 注意不能放到if里面，每次都要执行
        dfs(root.right, swap);
    }
}

// time: O(n), space: O(log(n) ~ n) = O(h);
