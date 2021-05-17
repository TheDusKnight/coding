package leetcode._0105_ConstructBinaryTreeFromPreorderAndInorderTraversal;
import java.util.HashMap;
import java.util.Map;

import leetcode.TreeNode;

// dfs tree
// https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/solution/mian-shi-ti-07-zhong-jian-er-cha-shu-di-gui-fa-qin/
class Solution {
    int[] preorder;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(0, 0, inorder.length-1);
    }
    
    private TreeNode helper(int preStart, int inStart, int inEnd) {
        if (preStart >= preorder.length || inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = map.get(root.val);
        
        // preStart+1 往左前进一个
        // inIndex-1 表示inorder范围缩小1
        root.left = helper(preStart + 1, inStart, inIndex-1);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex+1, inEnd);
        return root;
    }
}

// without hashmap
// time: nlogn to n^2
// space: O(1)

// with hashmap
// time: logn to n
// space:O(n)
