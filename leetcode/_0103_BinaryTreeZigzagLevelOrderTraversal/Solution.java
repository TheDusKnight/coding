package leetcode._0103_BinaryTreeZigzagLevelOrderTraversal;
import java.util.*;
import leetcode.TreeNode;

// bfs reverse list
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int minLen = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            if (minLen % 2 == 1) {
                Collections.reverse(list);
            }
            res.add(list);
            minLen++;
        }
        return res;
    }
}