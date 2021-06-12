package leetcode._0199_BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.TreeNode;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        if (root == null) return output;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode curr = queue.poll();
                if (size == 0) {
                    output.add(curr.val);
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }

            }
        }
        return output;
    }
}