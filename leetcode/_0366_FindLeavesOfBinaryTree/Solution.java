package leetcode._0366_FindLeavesOfBinaryTree;

import java.util.ArrayList;
import java.util.List;

import leetcode.TreeNode;

// recursion find height
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> findLeaves(TreeNode root) {
        res = new ArrayList<>();
        if (root == null) return res;
        
        height(root);
        return res;
    }
    
    private int height(TreeNode cur) {
        if (cur == null) return -1;
        
        int lev = 1 + Math.max(height(cur.left), height(cur.right));
        if (res.size() <= lev) res.add(new ArrayList<>());
        List<Integer> level = res.get(lev);
        level.add(cur.val);
        
        return lev;
    }
}

// time: O(N); space: O(N);
