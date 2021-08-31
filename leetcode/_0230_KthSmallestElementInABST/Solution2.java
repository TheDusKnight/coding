package leetcode._0230_KthSmallestElementInABST;

import java.util.Stack;

import leetcode.TreeNode;

// stack模拟inorder
class Solution2 {
    public int kthSmallest(TreeNode root, int k) {
        // cc
        
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }
}

// time: O(N); space: O(N);