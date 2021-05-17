package jianzhioffer.tree._07;

import java.util.HashMap;
import java.util.Map;

import leetcode.TreeNode;

/**
 * 重建二叉树
 * same lc105
 */

// https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/solution/mian-shi-ti-07-zhong-jian-er-cha-shu-di-gui-fa-qin/
public class Solution {
    int[] preorder;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i <inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(0, 0, preorder.length-1);
    }

    private TreeNode dfs(int root, int left, int right) {
        if (left > right) return null;
        TreeNode cur = new TreeNode(preorder[root]);
        int i = map.get(cur.val);
        cur.left = dfs(root+1, left, i-1);
        cur.right =dfs(root+i-left+1, i+1, right);
        return cur;
    }
}

// time: O(n); space: O(n);
