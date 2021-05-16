package leetcode._0113_PathSumII;
import java.util.*;
import leetcode.TreeNode;

// dfs，最好不要用recursion因为时间复杂度高
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res; // 不需要
        
        getSum(root, sum, 0, new ArrayList<>(), res);
        return res;
    }
    
    private void getSum(TreeNode root, int sum, int curSum, List<Integer> path, List<List<Integer>> res) {
        if (root == null) return;
        
        path.add(root.val);
        if (curSum+root.val == sum && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        } else {
            getSum(root.left, sum, curSum+root.val, path, res);
            getSum(root.right, sum, curSum+root.val, path, res);
        }
        path.remove(path.size()-1);
    }
}

// time: O(n)
