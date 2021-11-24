package leetcode._0450_DeleteNodeInABST;

import leetcode.TreeNode;

// https://leetcode.com/problems/delete-node-in-a-bst/discuss/93296/Recursive-Easy-to-Understand-Java-Solution
// tree CRUD recursion
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            else { // 两边都不为null
                int rightMin = getRightMin(root.right);
                // make current node value as right smallest value so BST is still valid
                root.val = rightMin;
                root.right = deleteNode(root.right, rightMin); // delete right smallest node
            }
        }
        
        return root;
    }
    
    private int getRightMin(TreeNode cur) {
        int min = cur.val;
        while (cur != null) {
            min = cur.val;
            cur = cur.left;
        }
        
        return min;
    }
}

// time: O(log(N)) if balanced; space: O(log(N)) if balanced;
