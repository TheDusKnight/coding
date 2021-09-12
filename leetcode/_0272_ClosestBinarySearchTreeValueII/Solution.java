package leetcode._0272_ClosestBinarySearchTreeValueII;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import leetcode.TreeNode;

// Map-heap/min-heap + dfs
class Solution {
    int k;
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        
        this.k = k;
        Queue<Integer> queue = new PriorityQueue<>((a, b) ->  (Math.abs(a - target) - Math.abs(b - target)) < 0 ? 1 : -1);
        dfs(root, queue);
        // while (k-- > 0) {
        //     res.add(queue.poll());
        // }
        while (!queue.isEmpty()) res.add(queue.poll());
        return res;
    }
    
    private void dfs(TreeNode root, Queue<Integer> queue) {
        if (root == null) return;
        
        queue.offer(root.val);
        if (queue.size() > k) queue.poll();
        dfs(root.left, queue);
        dfs(root.right, queue);
    }
}
