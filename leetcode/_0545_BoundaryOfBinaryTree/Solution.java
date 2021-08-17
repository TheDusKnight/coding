package leetcode._0545_BoundaryOfBinaryTree;

import java.util.ArrayList;
import java.util.List;

import leetcode.TreeNode;

class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null) return res;
        
        res.add(root.val);
        leftBoundary(root.left);
        if (root.left != null || root.right != null) leaves(root);
        rightBoundary(root.right);
        return res;
    }
    
    private void leftBoundary(TreeNode cur) { // top down
        // 注意根据题意leftBoundary不能包括leaves
        if (cur == null || (cur.left == null && cur.right == null)) return;
        
        res.add(cur.val);
        if (cur.left != null) leftBoundary(cur.left); // 能往左就往左
        else leftBoundary(cur.right);
    }
    
    private void rightBoundary(TreeNode cur) { // bottom up
        // 注意根据题意rightBoundary不能包括leaves
        if (cur == null || (cur.left == null && cur.right == null)) return;

        if (cur.right != null) rightBoundary(cur.right); // 能往右就往右
        else rightBoundary(cur.left);
        res.add(cur.val);
    }
    
    private void leaves(TreeNode cur) {
        if (cur == null) return;
        if (cur.left == null && cur.right == null) {
            res.add(cur.val);
            return;
        }
        leaves(cur.left);
        leaves(cur.right);
    }
}

// time: O(N);
