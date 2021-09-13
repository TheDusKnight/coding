package leetcode._0701_InsertIntoABinarySearchTree;

import leetcode.TreeNode;

// bst特性
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val < val) {
                if (cur.right != null) cur = cur.right;
                else {
                    cur.right = new TreeNode(val);
                    return root;
                }
            } else {
                if (cur.left != null) cur = cur.left;
                else {
                    cur.left = new TreeNode(val);
                    return root;
                }
            }
        }
        
        return root;
    }
}

// time: O(log(N)); space: O(1)
