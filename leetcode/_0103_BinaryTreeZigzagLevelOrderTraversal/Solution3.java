package leetcode._0103_BinaryTreeZigzagLevelOrderTraversal;
import java.util.*;
import leetcode.TreeNode;

// dfs two stacks
public class Solution3 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        boolean isEven = true;
        
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            
            if (isEven) {
                int size = stack1.size();
                while (size-- > 0) {
                    TreeNode cur = stack1.pop();
                    list.add(cur.val);
                    if (cur.left != null) stack2.push(cur.left);
                    if (cur.right != null) stack2.push(cur.right);
                }
            }
            
            else {
                int size = stack2.size();
                while (size-- > 0) {
                    TreeNode cur = stack2.pop();
                    list.add(cur.val);
                    if (cur.right != null) stack1.push(cur.right);
                    if (cur.left != null) stack1.push(cur.left);
                }
            }
            
            isEven = !isEven;
            res.add(list);
        }
        return res;
    }
}