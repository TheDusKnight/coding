package leetcode._0653_TwoSumIVInputIsABST;

import java.util.ArrayList;
import java.util.List;

import leetcode.TreeNode;

public class Solution {
    // dfs inorder拉平后two pointers
    List<Integer> list;
    public boolean findTarget(TreeNode root, int k) {
        // check bst是否size为1很重要，否则edge case出错
        if (root == null || (root.left == null && root.right == null))
            return false;
        list = new ArrayList<>();
        dfs(root);
        int l = 0, r = list.size()-1;
        while (l+1 < r) {
            int cur = list.get(l) + list.get(r);
            if (cur == k) {
                return true;
            } else if (cur > k) {
                r--;
            } else {
                l++;
            }
        }
        return list.get(l) + list.get(r) == k;
    }
    
    private void dfs(TreeNode root) {
        if (root == null)
            return;
        
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}

// time: O(n); space: O(n);
