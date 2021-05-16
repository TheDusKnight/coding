package leetcode._0114_FlattenBinaryTreeToLinkedList;
import leetcode.TreeNode;

// dfs
class Solution {
    TreeNode dummy = new TreeNode();
    public void flatten(TreeNode root) {
        if (root == null) return;
        
        // do sth
        dummy.right = root;
        dummy.left = null;
        dummy = root;
        
        // 此时right还没有被修改成3，在right还等于3时把它cache下来
        TreeNode r = root.right;
        flatten(root.left);
        // TreeNode r = root.right;
        flatten(r);
    }
}
