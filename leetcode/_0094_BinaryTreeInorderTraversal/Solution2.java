package leetcode._0094_BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.TreeNode;

// stack模拟recursion
class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode top = stack.pop();
                res.add(top.val);
                cur = top.right;
            }
        }
        
        return res;
    }
}

// time: O(N); space: O(N);
