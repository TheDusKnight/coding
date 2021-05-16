package leetcode._0105_ConstructBinaryTreeFromPreorderAndInorderTraversal;
import leetcode.TreeNode;
import java.util.*;

// dfs tree
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(0, 0, inorder.length-1, preorder, inorder);
    }
    
    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart >= preorder.length || inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = map.get(root.val);
        
        // int inIndex = 0;
        // for (int i = inStart; i <= inEnd; i++) {
        //     if (inorder[i] == root.val) {
        //         inIndex = i;
        //         break;
        //     }
        // }
        
        root.left = helper(preStart + 1, inStart, inIndex-1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex+1, inEnd, preorder, inorder);
        return root;
    }
}

// without hashmap
// time: nlogn to n^2
// space: O(1)

// with hashmap
// time: logn to n
// space:O(n)
