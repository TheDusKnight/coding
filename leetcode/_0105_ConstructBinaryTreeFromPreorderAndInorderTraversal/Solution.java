package leetcode._0105_ConstructBinaryTreeFromPreorderAndInorderTraversal;
import java.util.HashMap;
import java.util.Map;

import leetcode.TreeNode;

// dfs tree，preorder方式遍历，inorder定位
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
    
    private TreeNode helper(int preStart, int inStart, int inEnd) { // inStart, inEnd确定当前root左右child的范围
        if (preStart >= preorder.length || inStart > inEnd) return null; // inStart == inEnd时代表区间就是root本身
        
        TreeNode root = new TreeNode(preorder[preStart]);
        // 如果没有map，每次需要花O(n)时间找一下inIndex
        int inIndex = map.get(root.val); // inIndex是root在inOrder的位置
        
        // preStart+1 往左前进一个
        // inIndex-1 表示inorder范围缩小1
        root.left = helper(preStart + 1, inStart, inIndex-1);
        // inIndex - inStart是左区间的长度, preStart+1是左区间的起始index，preStart + 1 + inIndex - inStart是右区间的起始index
        root.right = helper(preStart + 1 + inIndex - inStart, inIndex+1, inEnd);
        return root;
    }
}

// without hashmap
// time: n*log(n) to n^2?
// space: O(1)

// with hashmap
// time: O(n)
// space:O(n)
