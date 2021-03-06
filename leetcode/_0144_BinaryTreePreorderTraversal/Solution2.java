package leetcode._0144_BinaryTreePreorderTraversal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.TreeNode;

// stack模拟recursion
class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                res.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode top = stack.pop();
                cur = top.right;
            }
        }
        
        return res;
    }
}
// time: O(N); space: O(N);
