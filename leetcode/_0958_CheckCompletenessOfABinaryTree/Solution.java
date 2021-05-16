package leetcode._0958_CheckCompletenessOfABinaryTree;
import java.util.*;
import leetcode.TreeNode;

public class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();

            if (cur == null) {
                flag = true;
            } else if (cur != null && flag == true) {
                return false;
            } else {
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        return true;
    }
}
