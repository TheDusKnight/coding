package leetcode._0984_AllPossibleFullBinaryTrees;

import java.util.ArrayList;
import java.util.List;

import leetcode.TreeNode;

public class Solution {
    // tree + dfs recursion，和NBTree类似注意n是所有node的个数不是只包括叶节点个数
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        if (n == 2) { // 当n为2时无法生成满二叉树
            return res;
        }
        // n每次dfs少1因为被当前root消耗一个
        for (int i = 1; i < n-1; i++) {
            List<TreeNode> lefts = allPossibleFBT(i);
            List<TreeNode> rights = allPossibleFBT(n-1-i);
            for (TreeNode left: lefts) {
                for (TreeNode right: rights) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}

// time: O(n^n)
