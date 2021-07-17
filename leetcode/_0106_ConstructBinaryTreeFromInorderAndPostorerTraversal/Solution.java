package leetcode._0106_ConstructBinaryTreeFromInorderAndPostorerTraversal;
import java.util.HashMap;
import java.util.Map;

import leetcode.TreeNode;

// dfs tree
class Solution {
    int[] postorder;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // cc
        this.postorder = postorder;
        for (int i = 0; i < postorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(postorder.length-1, 0, inorder.length-1);
    }
    
    private TreeNode helper(int postEnd, int inStart, int inEnd) {
        if (postEnd < 0 || inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inIndex = map.get(root.val);
        // inEnd-inIndex是右区间的长度
        root.left = helper(postEnd-(inEnd-inIndex)-1, inStart, inIndex-1);
        root.right = helper(postEnd-1, inIndex+1, inEnd);
        return root;
    }
}

// with hashmap
// time: O(n)
// space:O(n)