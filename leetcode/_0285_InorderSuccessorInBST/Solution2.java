package leetcode._0285_InorderSuccessorInBST;

import leetcode.TreeNode;

// inorder traverse
class Solution2 {
    boolean flag;
    TreeNode target;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // cc
        
        inOrder(root, p);
        return target;
    }
    
    private void inOrder(TreeNode cur, TreeNode p) {
        if (cur == null) return;
        
        inOrder(cur.left, p);
        if (flag && target != null) {
            target = cur;
            return;
        }
        if (cur == p) flag = true;
        inOrder(cur.right, p);
    }
}

// time: O(n) n is the number of nodes in tree
