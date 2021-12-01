package leetcode._0285_InorderSuccessorInBST;

import leetcode.TreeNode;

// inorder return
public class Solution3 {
    private TreeNode pre;
    private boolean flag = false;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p == null)
            throw new IllegalArgumentException();
        TreeNode res = dfs(root, p);
        if (flag) { // check if p exists, 如果p一定存在于tree则直接返回res
            return res;
        } else {
            throw new IllegalArgumentException();
        }
    }
    
    private TreeNode dfs(TreeNode root, TreeNode p) {
        if (root == null)
            return null;
        if (root == p)
            flag = true;
        
        TreeNode l = dfs(root.left, p);
        if (l != null) // 如果找到结果马上返回，否则继续找
            return l;
        if (pre == p) return root;
        pre = root;
        return dfs(root.right, p);
    }
}
// time: O(n) n is the number of nodes in tree
