package leetcode._0144_BinaryTreePreorderTraversal;
import java.util.*;
import leetcode.TreeNode;

// stack模拟
class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        // preorder: root, left, right
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.empty()) {
            TreeNode cur = stack.pop();
            result.add(cur.val);
            if (cur.right != null) { stack.push(cur.right); }
            if (cur.left != null) { stack.push(cur.left); }
        }
        return result;
    }
}
