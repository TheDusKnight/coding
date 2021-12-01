package leetcode._0653_TwoSumIVInputIsABST;

import java.util.ArrayList;
import java.util.List;

import leetcode.TreeNode;

// 最brute force用hash set
// 次brute force用inorder拉直 + two pointer
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        // cc
        
        List<Integer> list = new ArrayList<>();
        inOrder(list, root);
        
        int start = 0, end = list.size() - 1;
        while (start < end) { // 左右相邻，相等没搞清楚
            int curVal = list.get(start) + list.get(end);
            if (curVal == k) return true;
            else if (curVal < k) start++;
            else end--;
        }
        
        return false;
    }
    
    private void inOrder(List<Integer> list, TreeNode root) {
        if (root == null) return;
        
        inOrder(list, root.left);
        list.add(root.val);
        inOrder(list, root.right);
    }
}

// time: O(n); space: O(n);
