package leetcode._0106_ConstructBinaryTreeFromInorderAndPostorerTraversal;
import java.util.*;
import leetcode.TreeNode;

// dfs tree
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(postorder.length-1, 0, inorder.length-1, postorder, inorder);
    }
    
    private TreeNode helper(int postStart, int inStart, int inEnd, int[] postorder, int[] inorder) {
        if (postStart < 0 || inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(postorder[postStart]);
        int inIndex = map.get(root.val);
        
        root.left = helper(postStart-(inEnd-inIndex+1), inStart, inIndex-1, postorder, inorder);
        root.right = helper(postStart-1, inIndex+1, inEnd, postorder, inorder);
        return root;
    }
}
