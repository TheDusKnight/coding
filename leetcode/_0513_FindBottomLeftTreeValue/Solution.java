package leetcode._0513_FindBottomLeftTreeValue;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.TreeNode;

// Level order traversal
public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return 0;

        int leftMost = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) leftMost = node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return leftMost;
    }
}