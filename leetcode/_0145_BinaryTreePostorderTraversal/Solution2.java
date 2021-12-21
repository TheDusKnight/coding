package leetcode._0145_BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.TreeNode;

// postorder只能使用stack模拟recursion第二种写法
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode pre = null;
        
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek(); // peek错写成pop
            if (pre == null || pre.left == cur || pre.right == cur) { // cur左右未摸
                if (cur.left != null) { // 有左边走左边
                    stack.push(cur.left);
                } else if (cur.right != null) { // 没左边走右边
                    stack.push(cur.right);
                } else { // 都没有输出根
                    res.add(stack.pop().val);
                }
            } else if (pre == cur.left) { // cur左边摸完
                if (cur.right != null) {
                    stack.push(cur.right);
                } else {
                    res.add(stack.pop().val);
                }
            } else if (pre == cur.right) { // cu左右摸完
                res.add(stack.pop().val);
            }
            pre = cur;
        }
        
        return res;
    }
}
// time: O(N); space: O(N);
