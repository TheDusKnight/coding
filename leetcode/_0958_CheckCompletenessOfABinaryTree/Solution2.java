package leetcode._0958_CheckCompletenessOfABinaryTree;
import leetcode.TreeNode;
import java.util.*;

public class Solution2 {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            
            if (cur.left != null) {
                if (flag == true) return false;
                queue.offer(cur.left);
            } else flag = true;
            if (cur.right != null) {
                if (flag == true) return false;
                queue.offer(cur.right);
            } else flag = true;
        }
        return true;
    }
}