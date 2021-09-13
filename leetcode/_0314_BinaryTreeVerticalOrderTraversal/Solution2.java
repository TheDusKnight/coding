package leetcode._0314_BinaryTreeVerticalOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.TreeNode;

class Pair<K, V> {
    K k;
    V v;
    
    public Pair(K k, V v) {
        this.k = k;
        this.v = v;
    }
}

// 自写bfs+伪hashMap
class Solution2 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        List<Integer>[] map = new ArrayList[200];
        for (int i = 0; i < 200; i++) {
            map[i] = new ArrayList<>();
        }
        
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair<Integer, TreeNode>(0, root));
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Pair<Integer, TreeNode> cur = queue.poll();
                int levelIdx = cur.k;
                TreeNode curNode = cur.v;
                map[levelIdx+100].add(curNode.val);
                
                if (curNode.left != null) queue.offer(new Pair<Integer, TreeNode>(levelIdx-1, curNode.left));
                if (curNode.right != null) queue.offer(new Pair<Integer, TreeNode>(levelIdx+1, curNode.right));
            }
        }
        
        for (List<Integer> list: map) {
            if (!list.isEmpty()) {
                res.add(list);
            }
        }
        
        return res;
    }
}
