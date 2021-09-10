package leetcode._0103_BinaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import leetcode.TreeNode;

// dfs,逻辑和bfs差不多
class Solution4 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        dfs(root, 0, res);
        return res;
    }
    
    private void dfs(TreeNode root, int level, List<List<Integer>> res) {
        if (level == res.size()) {
            List<Integer> list = new LinkedList<>();
            list.add(root.val);
            res.add(list);
        } else {
            if (level % 2 == 1) res.get(level).add(0, root.val);
            else res.get(level).add(root.val);
        }
        
        if (root.left != null) dfs(root.left, level+1, res);
        if (root.right != null) dfs(root.right, level+1, res);
    }
}

// time: O(N); space: O(H) H是tree的高度
