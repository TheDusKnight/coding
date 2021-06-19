package leetcode._0285_InorderSuccessorInBST;

import leetcode.TreeNode;

public class Solution2 {
    // dfs inorder binary tree keep global variable O(n)
    TreeNode res; // 没赋值默认null
    TreeNode pre;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // cc
        dfs(root, p);
        return res;
    }
    
    private void dfs(TreeNode root, TreeNode p) {
        if (root == null) {
            return;
        }
        
        dfs(root.left, p);
        // in-order pre is updated and value is same as p, current node is in-order successor
        if (pre != null && pre.val == p.val) { // 如果pre和p完全一样可以改为 if (pre == p)
            res = root;
            // 这里不能加return，加了会导致后面的pre无法更新，从而让接下来所有successor以为无法更新的pre是自己的pre并且符合check，从而不断更新res，最终导致错误结果
            // return;
        }
        // 每次in-order记录一下pre
        pre = root;
        dfs(root.right, p);
    }
}
// time: O(n) n is the number of nodes in tree
