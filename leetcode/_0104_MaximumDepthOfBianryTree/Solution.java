package leetcode._0104_MaximumDepthOfBianryTree;
import leetcode.TreeNode;

public class Solution {
    // 标准recursion
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    // 按照题意用dfs写
    int maxDep;
    public int maxDepth2(TreeNode root) {
        // if (root == null) return 0;
        
        maxDep = 0;
        dfs(root, 0);
        return maxDep;
    }
    
    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            maxDep = Math.max(maxDep, depth);
            return;
        }
        
        depth++;
        dfs(root.left, depth);
        dfs(root.right, depth);
    }
}
// time: O(n) 每个node都遍历一遍 or 2^0 + 2^1 + 2^2 + ... + 2^(log(2, n)-1) = 2^0 + 2^1 + 2^2 + ... + n/2 = n
// space: stack O(log(n)) to O(n)