package leetcode._0314_BinaryTreeVerticalOrderTraversal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import leetcode.TreeNode;

// 自写bfs+hashMap
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        Map<Integer, List<Integer>> colMap = new HashMap<>();
        Queue<Pair<Integer, TreeNode>> queue = new LinkedList<>();
        queue.offer(new Pair<>(0, root));
        
        while (!queue.isEmpty()) {
            Pair<Integer, TreeNode> cur = queue.poll();
            int levelIdx = cur.k;
            TreeNode curNode = cur.v;
            if (!colMap.containsKey(levelIdx)) {
                colMap.put(levelIdx, new ArrayList<>());
            }
            colMap.get(levelIdx).add(curNode.val);
            
            if (curNode.left != null) queue.offer(new Pair<>(levelIdx-1, curNode.left));
            if (curNode.right != null) queue.offer(new Pair<>(levelIdx+1, curNode.right));
        }
        
        List<Integer> sortedKeys = new ArrayList<> (colMap.keySet());
        Collections.sort(sortedKeys);
        for (int key: sortedKeys) {
            res.add(colMap.get(key));
        }
        return res;
    }
}
// time: O(n + n*log(n))
// space: O(n)