package leetcode._0515_FindLargestValueInEachTreeRow;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.TreeNode;


public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // int minLen = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int localMax = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.val > localMax) localMax = cur.val;
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            res.add(localMax);
            // minLen++;
        }
        return res;
    }
}