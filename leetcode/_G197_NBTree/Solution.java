package leetcode._G197_NBTree;

import java.util.ArrayList;
import java.util.List;

import leetcode.TreeGenerator;
import leetcode.TreeNode;

public class Solution {
    // tree dfs
    // Define a tree that each node has 0 or 2 children. Given number of leaves, generate all possible trees.
    public List<TreeNode> gen(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n == 1) {
            res.add(new TreeNode(1));
            return res;
        }

        for (int i = 1; i < n; i++) {
            List<TreeNode> lefts = gen(i);
            List<TreeNode> rights = gen(n-i);
            for (TreeNode left: lefts) {
                for (TreeNode right: rights) {
                    TreeNode root = new TreeNode(1);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeGenerator gen = new TreeGenerator();
        List<TreeNode> res = sol.gen(3);
        for (TreeNode root: res) {
            System.out.println(gen.serialize(root));
        }
    }
}

// time: O(n^n)?
