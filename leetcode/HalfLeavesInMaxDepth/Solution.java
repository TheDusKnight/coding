package leetcode.HalfLeavesInMaxDepth;

import leetcode.TreeGenerator;
import leetcode.TreeNode;

// Amazon onsite
public class Solution {
    int notMaxLeaves = 0;
    int maxLeaves = 0;
    int maxDepth;
    public boolean halfLeavesInMaxDepth(TreeNode root) {
        // cc

        maxDepth = findMaxDepth(root);
        dfs(root, 0);        
        return maxLeaves > notMaxLeaves;
    }

    private int findMaxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = findMaxDepth(root.left);
        int right = findMaxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            if (level == maxDepth) maxLeaves++;
            else notMaxLeaves++;
            return;
        }

        level++;
        dfs(root.left, level);
        dfs(root.right, level);
    }

    public static void main(String[] args) {
        // String data = "3,9,20,#,#,15,7,2,8,6";
        String data = "1,#,2";
        TreeNode root = TreeGenerator.deserialize(data);
        // System.out.println(TreeGenerator.serialize(root));
        Solution sol = new Solution();
        System.out.println(sol.halfLeavesInMaxDepth(root));
    }
}
