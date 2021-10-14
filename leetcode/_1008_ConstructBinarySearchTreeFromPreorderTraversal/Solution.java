package leetcode._1008_ConstructBinarySearchTreeFromPreorderTraversal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import leetcode.TreeNode;

class Solution {
    int[] preorder;
    Map<Integer, Integer> map;
    public TreeNode bstFromPreorder(int[] preorder) {
        // cc
        
        this.preorder = preorder;
        int[] inorder = preorder.clone();
        Arrays.sort(inorder);
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return dfs(0, 0, inorder.length-1);
    }
    
    private TreeNode dfs(int preStart, int inStart, int inEnd) {
        if (preStart >= preorder.length || inStart > inEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIdx = map.get(preorder[preStart]);
        
        root.left = dfs(preStart+1, inStart, inIdx-1);
        root.right = dfs(preStart+1+inIdx-inStart, inIdx+1, inEnd);
        return root;
    }
}
