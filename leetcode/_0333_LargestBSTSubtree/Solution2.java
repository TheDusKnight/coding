package leetcode._0333_LargestBSTSubtree;

import leetcode.TreeNode;

// dfs brute force, valid bst + dfs
class Solution2 {
    int largest = 0;
    int curLargest = 0;
    TreeNode pre;
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        
        recursion(root);
        return largest;
    }
    
    private void recursion(TreeNode root) {
        if (root == null) return;
        
        recursion(root.left);
        recursion(root.right);
        
        pre = null;
        curLargest = 0;
        // 注意每次初始化pre和curLargest否则下一次eval会出错
        if (validBST(root)) largest = Math.max(largest, curLargest);
    }
    
    private boolean validBST(TreeNode root) {
        if (root == null) return true;
        
        boolean left = validBST(root.left);
        if (!left) return false;
        
        if (pre != null && pre.val >= root.val) return false;
        pre = root;
        curLargest++;
        
        boolean right = validBST(root.right);
        return right;
    }
}
