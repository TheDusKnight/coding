package leetcode._0222_CountCompleteTreeNode;
import leetcode.TreeNode;

// dfs
class Solution2 {
    int count = 0;
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        
        dfs(root);
        return count;
    }
    
    private void dfs(TreeNode root) {
        if (root == null) return;
        
        count++;
        dfs(root.left);
        dfs(root.right);
    }
}
