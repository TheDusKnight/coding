package leetcode._0173_BinarySearchTreeIterator;

import java.util.Stack;

import leetcode.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// iterator + stack 用时间换空间
// 653. Two Sum IV - Input is a BST的简化版
class BSTIterator2 {
    Stack<TreeNode> stack;
    public BSTIterator2(TreeNode root) {
        // cc
        
        stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode cur = stack.pop();
        int res = cur.val;
        cur = cur.right;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        
        return res;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty(); // true false 搞错了
    }
}

// time: O(H) for init, O(H) for next(), O(1) for hasNext();
// space: O(H)

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
